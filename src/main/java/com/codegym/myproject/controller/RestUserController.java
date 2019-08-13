package com.codegym.myproject.controller;

import com.codegym.myproject.model.News;
import com.codegym.myproject.model.User;
import com.codegym.myproject.securityService.UserPrincipal;
import com.codegym.myproject.service.NewsService;
import com.codegym.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/api/news")
public class RestUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;


    @PostMapping("/create")
    public ResponseEntity<Void> CreateNews(@RequestBody News news, Principal principal) {
            String name = principal.getName();
            User user = userService.findByUserName(name);
            News news1 = new News();
            news1.setAuthor(news.getAuthor());
            news1.setContent(news.getContent());
            news1.setUser(user);
            newsService.save(news1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
