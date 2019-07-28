package com.vastika.training.capstone.suchanaapi.controller;


import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles")
    public ResponseEntity<List<Article>> findAll(){
        return new ResponseEntity<>(this.articleService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/articles/{id}")
    public ResponseEntity<Article> findById(@PathVariable("id") int id){
        return new ResponseEntity<>(this.articleService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        log.info("createArticle() -> {}", article);
        article.setPublishDate(LocalDate.now());
        article.setNoOfViews(0);
        return new ResponseEntity<>(this.articleService.create(article), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Article> updateArticle(@RequestBody Article article, @PathVariable("id") int id){
        log.info("updateArticle() -> {}", id);
        article.setId(id);
        return new ResponseEntity<>(this.articleService.update(article), HttpStatus.OK);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") int id){
        log.info("deleteArticle() -> {}", id);
        this.articleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
