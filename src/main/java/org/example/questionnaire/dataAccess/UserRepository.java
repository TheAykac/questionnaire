package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);

    boolean existsByUserCode(String userCode);

    boolean existsByUsername(String username);
}
