package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.concretes.questions.DateQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateQuestionRepository extends JpaRepository<DateQuestion, Long> {
}
