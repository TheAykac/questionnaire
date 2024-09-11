package org.example.questionnaire.model.concretes.questions;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.abstracts.BaseQuestion;

@Entity
@Getter
@Setter
public class LinearScaleQuestion extends BaseQuestion {
    private int minScale;
    private int maxScale;
}
