package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    Article findById(int id);
    Article create(Article article);
    Article update(Article article);
    void delete(int id);
//    Article findByTitle(String title);
}
