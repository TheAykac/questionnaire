package org.example.questionnaire.model.concretes.answers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.concretes.questions.CheckboxQuestion;

import java.util.List;

@Entity
@Getter
@Setter
public class CheckboxAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private CheckboxQuestion question;

    @ElementCollection
    private List<String> selectedOptions;
}
