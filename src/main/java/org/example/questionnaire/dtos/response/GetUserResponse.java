package org.example.questionnaire.dtos.response;

import lombok.Data;

@Data
public class GetUserResponse {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private String userCode;

    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
}
