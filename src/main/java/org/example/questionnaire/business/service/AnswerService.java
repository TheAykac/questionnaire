package org.example.questionnaire.business.service;

import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.dtos.request.AnswerRequest;
import org.example.questionnaire.model.abstracts.BaseAnswer;

public interface AnswerService {
    DataResult<BaseAnswer> saveAnswer(AnswerRequest answerRequest);
}
