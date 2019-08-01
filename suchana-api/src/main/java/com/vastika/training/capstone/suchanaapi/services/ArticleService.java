package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);
    List<Article> findAll();
    Article findById(int id);
    List<Article> findByAuthorId(Integer authorId);
    List<Article> findByCategory(String category);
    List<Article> findByTag(String tag);
    void deleteArticle(int id);
}
