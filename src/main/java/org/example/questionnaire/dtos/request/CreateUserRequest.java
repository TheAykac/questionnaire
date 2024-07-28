package org.example.questionnaire.dtos.request;

import lombok.Builder;
import org.example.questionnaire.model.Role;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities,
        String surname,
        String email,
        String address,
        String phoneNumber
) {
}
