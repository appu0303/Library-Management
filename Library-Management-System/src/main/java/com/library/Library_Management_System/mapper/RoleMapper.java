package com.library.Library_Management_System.mapper;

import com.library.Library_Management_System.dto.RoleDTO;
import com.library.Library_Management_System.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(Role role);
    Role toEntity(RoleDTO dto);

    List<RoleDTO> toDTOs(List<Role> roles);
    List<Role> toEntities(List<RoleDTO> dtos);
}