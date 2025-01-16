package com.example.demoFinal.controller;

import com.example.demoFinal.dto.UserDto;
import com.example.demoFinal.model.RegistrationRequest;
import com.example.demoFinal.model.Role;
import com.example.demoFinal.model.User;
import com.example.demoFinal.service.RoleService;
import com.example.demoFinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping({"/users/create"})
    public String displayCreateUserForm(@RequestParam(value="registrationSuccess", required = false) String success, Model model) {

        model.addAttribute("title", "Register");
        model.addAttribute("registrationSuccess", success);
        model.addAttribute("user", new RegistrationRequest());
        List<Role> roles = roleService.findAllRoles(); // Obține lista de roluri
        model.addAttribute("roles", roles);
        return "/user/create";
    }

    @PostMapping({"/users/create"})
    public String processCreateUsersForm(@ModelAttribute("user") RegistrationRequest registrationRequest, RedirectAttributes redirectAttributes ) {

        UserDto userDto = userService.registerUser(registrationRequest);

        redirectAttributes.addAttribute("registrationSuccess", "Success");

        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String displayDeleteUserForm(Model model) {
        model.addAttribute("title", "Delete User");
        model.addAttribute("users", this.userService.getAllUsers());
        return "user/delete";
    }

    @PostMapping("/users/delete")
    public String processDeleteUserForm(@ModelAttribute("userUsernames") String[] userUsernames) {
        if (userUsernames != null) {
            for(String username : userUsernames){
                Optional<User> userOpt = userService.findByUsername(username);
                if(!userOpt.isEmpty()) {
                    this.userService.deleteUser(userOpt.get());
                }
            }
        }
        return "redirect:/users";
    }

    @GetMapping({"/users/update"})
    public String displayEditUserForm(Model model) {
        model.addAttribute("title", "Edit users");
        model.addAttribute("users", this.userService.getAllUsers());
        return "user/update";
    }




}