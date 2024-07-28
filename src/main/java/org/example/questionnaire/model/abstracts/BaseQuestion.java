package org.example.questionnaire.model.abstracts;

import jakarta.persistence.*;
import lombok.Data;
import org.example.questionnaire.core.utilities.constant.QuestionTypes;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class BaseQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String questionText;
    private String createUserCode;
    @Enumerated(EnumType.STRING)
    private QuestionTypes questionType;
}
