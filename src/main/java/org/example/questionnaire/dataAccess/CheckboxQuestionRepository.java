package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.concretes.questions.CheckboxQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckboxQuestionRepository extends JpaRepository<CheckboxQuestion, Long> {
}
