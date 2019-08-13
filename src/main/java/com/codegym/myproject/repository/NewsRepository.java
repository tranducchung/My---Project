package com.codegym.myproject.repository;

import com.codegym.myproject.model.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News,Integer> {
}
