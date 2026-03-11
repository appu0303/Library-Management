package com.library.Library_Management_System.controller.api;

import com.library.Library_Management_System.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API", description = "CRUD operations for users")
@RequestMapping("/api/users")
public interface UserApi {

    @Operation(summary = "Create a new user")
    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);

    @Operation(summary = "Get a user by ID")
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id);

    @Operation(summary = "Get all users")
    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @Operation(summary = "Update a user by ID")
    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO);

    @Operation(summary = "Delete a user by ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);

}
