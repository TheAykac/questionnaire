package org.example.questionnaire.model.concretes.answers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.concretes.questions.LinearScaleQuestion;

@Entity
@Getter
@Setter
public class LinearScaleAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private LinearScaleQuestion question;

    private int selectedScale;
}
