package org.example.questionnaire.dtos.request;

public record AuthRequest(
        String username,
        String password
) {
}
