package org.example.questionnaire.model.concretes;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.abstracts.BaseQuestion;

@Entity
@Getter
@Setter
public class ParagraphQuestion extends BaseQuestion {
}
