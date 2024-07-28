package org.example.questionnaire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_LOGIN")
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "expire_date")
    private Date expireDate;
    @Column(name = "entire_time")
    private Date entireTime;
    @Column(name = "active")
    private boolean active;

}
