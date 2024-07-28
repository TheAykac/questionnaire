package org.example.questionnaire.dtos.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record TokenResponse(
        String accessToken,
        Date expireDate) {

}
