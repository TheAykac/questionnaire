package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.concretes.questions.MultipleChoiceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleChoiceQuestionRepository extends JpaRepository<MultipleChoiceQuestion, Long> {
}
