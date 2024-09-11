package org.example.questionnaire.business.impl;

import org.example.questionnaire.business.service.AnswerService;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.dtos.request.AnswerRequest;
import org.example.questionnaire.model.abstracts.BaseAnswer;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Override
    public DataResult<BaseAnswer> saveAnswer(AnswerRequest answerRequest) {
        switch (answerRequest.getQuestionTypes()){
            case PARAGRAPH:
            case MULTIPLE_CHOICE:
            case CHECKBOX:
            case DROPDOWN:
            case LINEAR_SCALE:
            case DATE:
            default:
        }
        return null;
    }
}
