package com.example.demoFinal.service;

import com.example.demoFinal.dto.RoleDto;
import com.example.demoFinal.mapper.RoleMapper;
import com.example.demoFinal.model.Role;
import com.example.demoFinal.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleDto getRoleById(Integer id){
        return roleMapper.roleEntityToDto(roleRepository.findById(id).orElse(null));
    }

    public RoleDto findByRole(String role){
        return roleMapper.roleEntityToDto(roleRepository.findByRole(role));
    }

    public List<RoleDto> getAllRoles(){
        return roleMapper.roleListEntityToDto(roleRepository.findAll());
    }
    public List<Role> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        System.out.println("Roles: " + roles);
        return roles;
    }
    public RoleDto createRole(Role role){
        return roleMapper.roleEntityToDto(roleRepository.save(role));
    }

    public RoleDto updateRole(Role role){
        return roleMapper.roleEntityToDto(roleRepository.save(role));
    }

    public void deleteRole(Role role){
        roleRepository.delete(role);
    }

}