package org.example.questionnaire.business.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.questionnaire.dtos.response.TokenResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface TokenProviderService {
    TokenResponse generateToken(String userName);

    Boolean validateToken(String token, UserDetails userDetails);

    Date extractExpiration(String token);

    String extractUser(String token);

    String resolveToken(HttpServletRequest request);

    Authentication getAuthentication(String username, String password);
}
