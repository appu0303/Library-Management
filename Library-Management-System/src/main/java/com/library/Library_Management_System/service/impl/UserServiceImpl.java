package com.library.Library_Management_System.service.impl;

import com.library.Library_Management_System.dto.UserDTO;
import com.library.Library_Management_System.entity.Role;
import com.library.Library_Management_System.entity.User;
import com.library.Library_Management_System.exception.ResourceNotFoundException;
import com.library.Library_Management_System.mapper.UserMapper;
import com.library.Library_Management_System.repository.RoleRepository;
import com.library.Library_Management_System.repository.UserRepository;
import com.library.Library_Management_System.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = userMapper.toEntity(userDTO);

        Set<Role> roles = userDTO.getRoles().stream()
                .map(dto -> roleRepository.findById(dto.getId())
                        .orElseThrow(()->new ResourceNotFoundException("Role not found with id : "+dto.getId())))
                .collect(Collectors.toSet());

        user.setRoles(roles);

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id: "+id));

        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id : "+id));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setEmail(userDTO.getEmail());

        if(userDTO.getRoles() != null)
        {
            Set<Role> roles = userDTO.getRoles().stream()
                    .map(dto ->roleRepository.findById(dto.getId())
                            .orElseThrow(()-> new ResourceNotFoundException("Role not found with id : "+dto.getId())))
                    .collect(Collectors.toSet());

            existingUser.setRoles(roles);
        }

        return userMapper.toDTO(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long id) {

        if(!userRepository.existsById(id))
        {
            throw new RuntimeException("User not found with id : "+id);
        }
        userRepository.deleteById(id);


    }
}
