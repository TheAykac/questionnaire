package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.concretes.questions.LinearScaleQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinearScaleQuestionRepository extends JpaRepository<LinearScaleQuestion, Long> {

}
