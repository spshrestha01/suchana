package com.vastika.training.capstone.suchanaapi.controller;


import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import com.vastika.training.capstone.suchanaapi.services.UserService;
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
    private UserService userService;

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

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> findArticleById(@PathVariable("id") int id){
        Article article = this.articleService.findById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
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
        User user = this.userService.findById(authorId);
        article.setUser(user);
        Article saved = articleService.save(article);

        log.info("Article saved -> id : {}", saved.getId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/authors/{id}/articles")
    public ResponseEntity<List<Article>> getArticlesByAuthor(@PathVariable("id") int authorId){
        return new ResponseEntity<>(this.articleService.findByAuthorId(authorId), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{authorId}/articles/{articleId}", method = RequestMethod.PUT)
    public ResponseEntity<Article> updateArticle(@Valid @RequestBody Article article, BindingResult result,
                                                 @PathVariable("articleId") int articleId, @PathVariable("authorId") int authorId){
        log.info("updateArticle() -> id : {}", articleId);

        if(result.hasErrors()){
            throw new SuchanaDataException("Invalid Payroll", result.getFieldErrors());
        }
        User user = this.userService.findById(authorId);
        article.setId(articleId);

        if(user.getId() != article.getUser().getId()){
            throw new SuchanaApiException("The author is not authorized to update the article with id :" + article.getId(), 400);
        }
        Article updated = this.articleService.save(article);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{authorId}/articles/{articleId}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteArticle(@RequestParam Article article,
                                                    @PathVariable("authorId") int authorId, @PathVariable("articleId") int articleId){
       User user = this.userService.findById(authorId);

        if(user.getId() != article.getUser().getId()){
            throw new SuchanaApiException("The author is not authorized to delete the article with id :" + article.getId(), 400);
        }
        this.articleService.deleteArticle(articleId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
