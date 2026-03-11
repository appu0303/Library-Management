package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.controller.api.RoleApi;
import com.library.Library_Management_System.dto.RoleDTO;
import com.library.Library_Management_System.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController implements RoleApi {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {

        this.roleService = roleService;
    }

    @Override
    public ResponseEntity<RoleDTO> createRole(RoleDTO roleDTO) {

        RoleDTO createdRole = roleService.createRole(roleDTO);
        return ResponseEntity.ok(createdRole);
    }

    @Override
    public ResponseEntity<RoleDTO> getRoleById(Long id) {

        RoleDTO role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

    @Override
    public ResponseEntity<List<RoleDTO>> getAllRoles() {

        List<RoleDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @Override
    public ResponseEntity<RoleDTO> updateRole(Long id, RoleDTO roleDTO) {

        RoleDTO updatedRole = roleService.updateRole(id, roleDTO);
        return ResponseEntity.ok(updatedRole);
    }

    @Override
    public ResponseEntity<Void> deleteRole(Long id) {

        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
