package com.codegym.myproject.controller;

import com.codegym.myproject.model.News;
import com.codegym.myproject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/api/allNews")
    public ResponseEntity<List<News>> getAllNews() {
        List<News> news = newsService.findAll();
        if(news.isEmpty()) {
            return new ResponseEntity<List<News>>(news, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<News>>(news,HttpStatus.OK);
    }
}
