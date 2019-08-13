package com.codegym.myproject.service;

import com.codegym.myproject.model.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();
    void save(News news);
}
