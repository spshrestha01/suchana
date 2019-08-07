package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.repositories.ArticleRepository;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        log.info("save()");
        Article articleInDb = this.articleRepository.findByTitle(article.getTitle());
        if(articleInDb != null){
            throw new SuchanaApiException("Article exists with the title:" + article.getTitle(), 409);
        }
        User user = article.getUser();
        if(!user.getCategories().contains(article.getCategory())){
            throw new SuchanaApiException("The article category does not match with the author category", 400);
        }
        return this.articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return this.articleRepository.findById(id);
    }

    @Override
    public List<Article> findByAuthorId(Integer authorId) {
        return this.articleRepository.findAllByAuthor(authorId);
    }

    @Override
    public List<Article> findByCategory(String category) {
        return this.articleRepository.findAllByCategory(category);
    }

    @Override
    public List<Article> findByTag(String tag) {
        return this.articleRepository.findAllByTag(tag);
    }

    @Override
    public void deleteArticle(int id) {
        this.articleRepository.deleteById(id);
    }
}
