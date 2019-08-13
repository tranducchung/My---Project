package com.codegym.myproject.controller;

import com.codegym.myproject.model.Role;
import com.codegym.myproject.model.User;
import com.codegym.myproject.service.RoleService;
import com.codegym.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@CrossOrigin
public class RestSingUpController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/singup")
    public ResponseEntity<Void> SingUpAccount(@RequestBody User user) {
        if (userService.findByUserName(user.getUsername()) == null) {
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleService.findByName("ROLE_USER"));
            user1.setRoles(roles);
            userService.save(user1);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
