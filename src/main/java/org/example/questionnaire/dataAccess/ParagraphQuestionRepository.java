package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.concretes.questions.ParagraphQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphQuestionRepository extends JpaRepository<ParagraphQuestion, Long> {
}
