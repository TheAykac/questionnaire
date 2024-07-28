package org.example.questionnaire.business.service;

import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.dtos.request.AuthRequest;

public interface UserLoginService {
    String login(AuthRequest authRequest) throws BusinessException;

    void logout() throws BusinessException;
}
