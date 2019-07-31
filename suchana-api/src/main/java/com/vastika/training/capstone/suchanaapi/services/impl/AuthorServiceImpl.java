package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.Author;
import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.repositories.AuthorRepository;
import com.vastika.training.capstone.suchanaapi.repositories.CategoryRepository;
import com.vastika.training.capstone.suchanaapi.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public Author update(Author author) {
        boolean exists = this.authorRepository.existsById(author.getId());
        if(!exists){
            throw new SuchanaApiException("No Author found with id: " + author.getId(), 404);
        }

        if(author.getCategories() == null){
            author.setCategories(new HashSet<>());
        }

        if(author.getArticles() == null){
            author.setArticles(new ArrayList<>());
        }

        return this.authorRepository.save(author);
    }

    @Override
    public Author createAuthor(Author author) {
        author.setArticles(new ArrayList<>());

        if(author.getCategories() == null){
            author.setCategories(new HashSet<>());
        }else{
            List<Category> existingCategories = this.categoryRepository.findAll();
            for(Category upcoming: author.getCategories()){
                if(!existingCategories.contains(upcoming)){
                    throw new SuchanaApiException("No Category exists with id: " + upcoming.getId() + ", name: " + upcoming.getName(), 400);
                }
            }
        }
        Author authorInDb = this.authorRepository.findByUsername(author.getUsername());

        if(authorInDb != null){
            throw new SuchanaApiException("Author exists with the username: " + authorInDb.getUsername(), 409);
        }

        Author created = this.authorRepository.save(author);
        log.info("Author created with id: {}", created.getId());
        return created;
    }
}
