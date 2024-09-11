package org.example.questionnaire.model.concretes.answers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.concretes.questions.ParagraphQuestion;

@Entity
@Getter
@Setter
public class ParagraphAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private ParagraphQuestion question;

    private String answerText;
}
