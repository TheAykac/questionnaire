package org.example.questionnaire.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.questionnaire.business.impl.UserServiceImpl;
import org.example.questionnaire.business.service.QuestionService;
import org.example.questionnaire.business.service.TokenProviderService;
import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.dtos.request.QuestionRequest;
import org.example.questionnaire.model.abstracts.BaseQuestion;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/questions/")
@Slf4j
public class QuestionController {
    private final QuestionService questionService;
    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final TokenProviderService tokenProviderService;

    @PostMapping("create-question")
    public DataResult<BaseQuestion> createQuestion(@RequestBody QuestionRequest questionRequest) throws BusinessException {
        return questionService.createQuestion(questionRequest);
    }

    @GetMapping("user")
    public boolean trueFalse() {
        return true;
    }


}
