package org.example.questionnaire.business.service;

import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.dtos.request.CreateUserRequest;
import org.example.questionnaire.dtos.response.CreateUserResponse;
import org.example.questionnaire.dtos.response.GetUserResponse;

public interface UserService {
    DataResult<GetUserResponse> getByUsername(String username) throws BusinessException;

    DataResult<CreateUserResponse> createUser(CreateUserRequest request) throws BusinessException;
}
