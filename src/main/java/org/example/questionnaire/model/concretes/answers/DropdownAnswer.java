package org.example.questionnaire.model.concretes.answers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.concretes.questions.DropdownQuestion;

@Entity
@Getter
@Setter
public class DropdownAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private DropdownQuestion question;

    private String selectedOption;
}
