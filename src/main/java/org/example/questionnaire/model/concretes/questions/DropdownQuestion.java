package org.example.questionnaire.model.concretes.questions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.abstracts.BaseQuestion;

import java.util.List;

@Entity
@Getter
@Setter
public class DropdownQuestion extends BaseQuestion {
    @ElementCollection
    @CollectionTable(name = "dropdown_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option")
    private List<String> options;
}
