package org.example.questionnaire.dtos.request;

import lombok.Data;
import org.example.questionnaire.core.utilities.constant.QuestionTypes;

import java.util.List;

@Data
public class QuestionRequest {
    private String questionText;
    private QuestionTypes questionType;
    private List<String> options; // Only for choice-based questions
    private int minScale; // Only for scale questions
    private int maxScale; // Only for scale questions
    private List<String> rows; // Only for grid questions
    private List<String> columns;
    private String createUserCode;// Only for grid questions
}
