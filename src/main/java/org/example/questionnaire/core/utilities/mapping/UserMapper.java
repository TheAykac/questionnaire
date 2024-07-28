package org.example.questionnaire.core.utilities.mapping;

import org.example.questionnaire.dtos.request.CreateUserRequest;
import org.example.questionnaire.dtos.response.CreateUserResponse;
import org.example.questionnaire.dtos.response.GetUserResponse;
import org.example.questionnaire.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {
    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "isEnabled", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    public abstract User createUserRequestToUser(CreateUserRequest createUserRequest);

    public abstract CreateUserResponse userToCreateUserResponse(User user);

    public abstract GetUserResponse userToGetUserResponse(User user);
}
