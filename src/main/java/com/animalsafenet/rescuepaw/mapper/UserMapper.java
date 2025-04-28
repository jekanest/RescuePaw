package com.animalsafenet.rescuepaw.mapper;

import com.animalsafenet.rescuepaw.model.UserDAO;
import com.animalsafenet.rescuepaw.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "role", target = "role")
    UserDAO toDTO(User user);

    @Mapping(source = "role", target = "role")
    User toEntity(UserDAO userDAO);
}
