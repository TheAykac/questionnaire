package org.example.questionnaire.model.concretes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.abstracts.BaseQuestion;

import java.util.List;

@Entity
@Getter
@Setter
public class MultipleChoiceQuestion extends BaseQuestion {
    @ElementCollection
    @CollectionTable(name = "cohices", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "choice")
    private List<String> choices;
    private String correctAnswer;
}
