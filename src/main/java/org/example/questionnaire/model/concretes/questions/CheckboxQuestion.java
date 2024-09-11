package org.example.questionnaire.model.concretes.questions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.abstracts.BaseQuestion;

import java.util.List;

@Entity
@Getter
@Setter
public class CheckboxQuestion extends BaseQuestion {
    @ElementCollection
    @CollectionTable(name = "checkboxes", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "checkbox")
    private List<String> checkboxes;
}
