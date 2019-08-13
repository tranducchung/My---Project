package com.codegym.myproject.service.impl;

import com.codegym.myproject.model.News;
import com.codegym.myproject.repository.NewsRepository;
import com.codegym.myproject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return (List<News>) newsRepository.findAll();
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

}
