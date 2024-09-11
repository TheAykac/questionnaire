package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.concretes.questions.DropdownQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DropdownQuestionRepository extends JpaRepository<DropdownQuestion, Long> {
}
