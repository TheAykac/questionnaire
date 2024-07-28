package org.example.questionnaire.core.utilities.mapping;

import org.example.questionnaire.dtos.response.TokenResponse;
import org.example.questionnaire.model.User;
import org.example.questionnaire.model.UserLogin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper
public abstract class UserLoginMapper {
    public static UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);

    public UserLogin toUserLogin(User user, TokenResponse tokenResponse) {
        UserLogin userLogin = new UserLogin();
        userLogin.setExpireDate(tokenResponse.expireDate());
        userLogin.setAccessToken(tokenResponse.accessToken());
        userLogin.setUserCode(user.getUserCode());
        userLogin.setEntireTime(new Date(System.currentTimeMillis()));
        userLogin.setActive(true);
        return userLogin;
    }
}
