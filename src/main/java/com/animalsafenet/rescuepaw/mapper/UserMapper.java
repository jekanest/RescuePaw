package com.animalsafenet.rescuepaw.mapper;

import com.animalsafenet.rescuepaw.model.UserDAO;
import com.animalsafenet.rescuepaw.repository.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDAO toDTO(User user);

    User toEntity(UserDAO userDAO);
}
