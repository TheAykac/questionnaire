package org.example.questionnaire.dtos.request;

import lombok.Data;
import org.example.questionnaire.core.utilities.constant.QuestionTypes;

@Data
public class AnswerRequest {
    private QuestionTypes questionTypes;

}
