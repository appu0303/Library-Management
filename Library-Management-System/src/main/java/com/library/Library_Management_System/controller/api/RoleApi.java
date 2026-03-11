package com.library.Library_Management_System.controller.api;

import com.library.Library_Management_System.dto.RoleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Role API", description = "CRUD operations for roles")
@RequestMapping("/api/roles")
public interface RoleApi {

    @Operation(summary = "Create a new role")
    @PostMapping
    ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO);

    @Operation(summary = "Get a role by ID")
    @GetMapping("/{id}")
    ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id);

    @Operation(summary = "Get all roles")
    @GetMapping
    ResponseEntity<List<RoleDTO>> getAllRoles();

    @Operation(summary = "Update a role by ID")
    @PutMapping("/{id}")
    ResponseEntity<RoleDTO> updateRole(Long id, RoleDTO roleDTO);

    @Operation(summary = "Delete a role by ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRole(Long id);
}
