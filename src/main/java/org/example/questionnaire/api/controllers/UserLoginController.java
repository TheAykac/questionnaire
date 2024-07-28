package org.example.questionnaire.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.questionnaire.business.service.TokenProviderService;
import org.example.questionnaire.business.service.UserLoginService;
import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.result.SuccessResult;
import org.example.questionnaire.dtos.request.AuthRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user-token")
@RequiredArgsConstructor
@Slf4j
public class UserLoginController {
    private final UserLoginService userLoginService;
    private final TokenProviderService tokenProviderService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) throws BusinessException {
        return userLoginService.login(authRequest);
    }

    @PostMapping("/logout")
    public SuccessResult login() throws BusinessException {
        userLoginService.logout();
        return new SuccessResult("success");
    }
}
