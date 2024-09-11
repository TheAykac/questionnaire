package org.example.questionnaire.model.concretes.questions;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.abstracts.BaseQuestion;

import java.util.Date;

@Entity
@Getter
@Setter
public class DateQuestion extends BaseQuestion {
    private Date date;
}
