package com.codegym.myproject.service.impl;

import com.codegym.myproject.model.Role;
import com.codegym.myproject.repository.RoleRepository;
import com.codegym.myproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String role) {
        return roleRepository.findByName(role);
    }
}
