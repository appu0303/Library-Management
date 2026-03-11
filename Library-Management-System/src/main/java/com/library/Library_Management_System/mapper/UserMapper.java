package com.library.Library_Management_System.mapper;

import com.library.Library_Management_System.dto.UserDTO;
import com.library.Library_Management_System.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mapping(target = "roles", source = "roles")
    UserDTO toDTO(User user);

    @Mapping(target = "roles", source = "roles")
    User toEntity(UserDTO dto);

    List<UserDTO> toDTOs(List<User> users);
    List<User> toEntities(List<UserDTO> dtos);

}
