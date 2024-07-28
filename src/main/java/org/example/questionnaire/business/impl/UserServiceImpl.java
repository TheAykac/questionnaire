package org.example.questionnaire.business.impl;

import lombok.RequiredArgsConstructor;
import org.example.questionnaire.business.service.UserService;
import org.example.questionnaire.core.utilities.constant.UserConstant;
import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.mapping.UserMapper;
import org.example.questionnaire.core.utilities.messages.BusinessMessages;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.core.utilities.result.SuccessDataResult;
import org.example.questionnaire.dataAccess.UserRepository;
import org.example.questionnaire.dtos.request.CreateUserRequest;
import org.example.questionnaire.dtos.response.CreateUserResponse;
import org.example.questionnaire.dtos.response.GetUserResponse;
import org.example.questionnaire.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(BusinessMessages.ErrorMessage.USER_NOT_FOUND + username);
        }
        return user;
    }

    @Override
    public DataResult<GetUserResponse> getByUsername(String username) throws BusinessException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new BusinessException(BusinessMessages.ErrorMessage.USER_NOT_FOUND);
        }
        GetUserResponse getUserResponse = userMapper.userToGetUserResponse(user);
        return new SuccessDataResult<>(getUserResponse, BusinessMessages.GlobalMessages.DATA_LISTED_SUCCESSFULLY);
    }

    @Override
    public DataResult<CreateUserResponse> createUser(CreateUserRequest request) throws BusinessException {
        checkByExistsUsername(request.username());
        User user = userMapper.createUserRequestToUser(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setUserCode(generateUserCode());
        userRepository.save(user);
        CreateUserResponse createUserResponse = userMapper.userToCreateUserResponse(user);
        return new SuccessDataResult<>(createUserResponse, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
    }

    private String generateUserCode() {
        StringBuilder userCodeBuilder = new StringBuilder(UserConstant.USER_CODE_LENGTH);
        Random random = new Random();
        do {
            for (int i = 0; i < 5; i++) {
                int characterIndex = random.nextInt(UserConstant.USER_CODE_CHARACTERS.length());
                userCodeBuilder.append(UserConstant.USER_CODE_CHARACTERS.charAt(characterIndex));
            }
        } while (userRepository.existsByUserCode(userCodeBuilder.toString()));

        return userCodeBuilder.toString();
    }

    private void checkByExistsUsername(String username) throws BusinessException {
        boolean existsUsername = userRepository.existsByUsername(username);
        if (existsUsername) {
            throw new BusinessException(BusinessMessages.ErrorMessage.USERNAME_ALREADY_EXISTS);
        }
    }
}
