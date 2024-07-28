package org.example.questionnaire.business.service;

import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.dtos.request.QuestionRequest;
import org.example.questionnaire.model.abstracts.BaseQuestion;

public interface QuestionService {
    DataResult<BaseQuestion> createQuestion(QuestionRequest questionRequest) throws BusinessException;
}
