package com.library.Library_Management_System.service.impl;

import com.library.Library_Management_System.dto.RoleDTO;
import com.library.Library_Management_System.entity.Role;
import com.library.Library_Management_System.exception.ResourceNotFoundException;
import com.library.Library_Management_System.mapper.RoleMapper;
import com.library.Library_Management_System.repository.RoleRepository;
import com.library.Library_Management_System.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {

        Role role = roleMapper.toEntity(roleDTO);
        return roleMapper.toDTO(roleRepository.save(role));
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        role.setName(roleDTO.getName());
        return roleMapper.toDTO(roleRepository.save(role));
    }

    @Override
    public void deleteRole(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        roleRepository.delete(role);
    }
}
