package com.example.demoFinal.model;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationRequest {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String emailAddress;
    private List<Role> roles;

}