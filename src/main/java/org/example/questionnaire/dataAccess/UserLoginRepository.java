package org.example.questionnaire.dataAccess;

import org.example.questionnaire.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    boolean existsByAccessTokenAndActive(String accessToken, boolean active);
}
