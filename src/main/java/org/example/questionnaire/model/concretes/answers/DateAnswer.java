package org.example.questionnaire.model.concretes.answers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.concretes.questions.DateQuestion;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DateAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private DateQuestion question;

    private LocalDate answerDate;
}
