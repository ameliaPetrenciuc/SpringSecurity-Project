package com.example.demoFinal.service;

import com.example.demoFinal.dto.UserDto;
import com.example.demoFinal.model.RegistrationRequest;
import com.example.demoFinal.model.User;
import com.example.demoFinal.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean checkEmail(String email);

    UserDto registerUser(RegistrationRequest registrationRequest);

    UserDto getLoginUser();

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    UserDto createUser(User user);

    UserDto updateUser(User user);
    Optional<User> findByUsername(String username);
    void deleteUser(User user);
}