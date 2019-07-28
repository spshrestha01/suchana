package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.repositories.ArticleRepository;
import com.vastika.training.capstone.suchanaapi.repositories.CategoryRepository;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return this.articleRepository.getOne(id);
    }

    @Override
    public Article create(Article article) {
        if(article.getCategory() == null){
            article.setCategory(new Category());
        }
        if(article.getTags() == null){
            article.setTags(new HashSet<>());
        }
        return this.articleRepository.save(article);
    }

    @Override
    public Article update(Article article) {
        boolean exists = this.articleRepository.existsById(article.getId());
        if(!exists){
            throw new SuchanaApiException("Article Not found with the id:" + article.getId(), 404);
        }
        if(article.getCategory() == null){
            article.setCategory(categoryRepository.getOne(1));
        }
        if(article.getTags() == null){
            article.setTags(new HashSet<>());
        }
        return this.articleRepository.save(article);
    }

    @Override
    public void delete(int id) {
        boolean exists = this.articleRepository.existsById(id);
        if(!exists){
            throw new SuchanaApiException("Article Not found with the id: " + id, 404);
        }
        this.articleRepository.deleteById(id);
    }
}
