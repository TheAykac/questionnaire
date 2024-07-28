package org.example.questionnaire.api.controllers;

import lombok.RequiredArgsConstructor;
import org.example.questionnaire.business.service.UserService;
import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.dtos.request.CreateUserRequest;
import org.example.questionnaire.dtos.response.CreateUserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/")
public class UserController {
    private final UserService userService;

    @PostMapping("create-user")
    public DataResult<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) throws BusinessException {
        return userService.createUser(request);
    }


}


