package com.codegym.myproject.service;

import com.codegym.myproject.model.Role;

public interface RoleService {
    Role findByName(String name);
}
