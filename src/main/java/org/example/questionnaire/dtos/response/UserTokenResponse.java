package org.example.questionnaire.dtos.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserTokenResponse {
    private String accessToken;
    private String userId;
    private Date expireDate;
}
