package org.example.questionnaire.business.impl;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.questionnaire.business.service.TokenProviderService;
import org.example.questionnaire.business.service.UserLoginService;
import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.mapping.UserLoginMapper;
import org.example.questionnaire.core.utilities.messages.BusinessMessages;
import org.example.questionnaire.dataAccess.UserLoginRepository;
import org.example.questionnaire.dataAccess.UserRepository;
import org.example.questionnaire.dtos.request.AuthRequest;
import org.example.questionnaire.dtos.response.TokenResponse;
import org.example.questionnaire.model.User;
import org.example.questionnaire.model.UserLogin;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {
    private final UserLoginMapper userLoginMapper = UserLoginMapper.INSTANCE;
    private final AuthenticationManager authenticationManager;
    private final TokenProviderService tokenProviderService;
    private final UserRepository userRepository;
    private final UserLoginRepository userLoginRepository;
    private final HttpSession session;

    @Override
    public String login(AuthRequest authRequest) throws BusinessException {
        authenticateUser(authRequest);
        TokenResponse tokenResponse = tokenProviderService.generateToken(authRequest.username());
        UserLogin userLogin = saveUserLogin(authRequest.username(), tokenResponse);
        session.setAttribute("userLogin", userLogin);
        return tokenResponse.accessToken();
    }

    private void authenticateUser(AuthRequest authRequest) throws BusinessException {
        Authentication authentication = tokenProviderService.getAuthentication(authRequest.username(), authRequest.password());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if (!authenticate.isAuthenticated()) {
            throw new BusinessException(BusinessMessages.ErrorMessage.INVALID_USERNAME_OR_PASSWORD);
        }
    }

    private UserLogin saveUserLogin(String username, TokenResponse tokenResponse) {
        User user = userRepository.findByUsername(username);
        UserLogin userLogin = userLoginMapper.toUserLogin(user, tokenResponse);
        return userLoginRepository.save(userLogin);
    }

    @Override
    public void logout() throws BusinessException {
        try {
            UserLogin userLogin = (UserLogin) session.getAttribute("userLogin");
            userLogin.setActive(false);
            userLoginRepository.save(userLogin);
        } catch (Exception e) {
            throw new BusinessException(BusinessMessages.ErrorMessage.SYSTEM_ERROR);
        }
    }
}
