package org.example.questionnaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.questionnaire.core.utilities.constant.QuestionTypes;

@Data
@Entity(name = "QUESTIONS")
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "question_types")
    private QuestionTypes questionTypes;
    @ManyToOne(cascade = CascadeType.ALL)
    private User userId;

}
