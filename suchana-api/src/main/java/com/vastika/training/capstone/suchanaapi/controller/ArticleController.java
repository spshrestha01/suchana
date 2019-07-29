package com.vastika.training.capstone.suchanaapi.controller;


import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.models.Author;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import com.vastika.training.capstone.suchanaapi.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> findArticle(@RequestParam(value = "category", required = false) String category,
                                                     @RequestParam(value = "tag", required = false) String tag){
        List<Article> articles;
        if(category != null){
            articles = this.articleService.findByCategory(category);
        }else if(tag != null){
            articles = this.articleService.findByTag(tag);
        }else{
            articles = this.articleService.findAll();
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }


    // /api/v1/users/{id}/accounts
    // example for api naming

    @PostMapping("/authors/{id}/articles")
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article, BindingResult result,
                                                 @PathVariable("id") int authorId){
        log.info("createArticle() -> authorId: {}", authorId);

        if(result.hasErrors()){
            throw new SuchanaDataException("Invalid Payload!", result.getFieldErrors());
        }

        article.setPublishDate(LocalDateTime.now());
        Author author = this.authorService.findById(authorId);
        article.setAuthor(author);
        Article saved = articleService.save(article);

        log.info("Article saved -> id : {}", saved.getId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/authors/{id}/articles")
    public ResponseEntity<List<Article>> getArticlesByAuthor(@PathVariable("id") int authorId){
        return new ResponseEntity<>(this.articleService.findByAuthorId(authorId), HttpStatus.OK);
    }


}
