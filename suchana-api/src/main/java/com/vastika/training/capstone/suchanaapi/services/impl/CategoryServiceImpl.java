package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.repositories.CategoryRepository;
import com.vastika.training.capstone.suchanaapi.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.getOne(id);
    }

    @Override
    public Category update(Category category) {
        boolean exists = this.categoryRepository.existsById(category.getId());
        if(!exists){
            throw new SuchanaApiException("No Category found with the id : " + category.getId(), 404);
        }
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        boolean exists = this.categoryRepository.existsById(id);
        if(!exists){
            throw new SuchanaApiException("No Category found with the id: " + id, 404);
        }
        this.categoryRepository.deleteById(id);
    }

    @Override
    public Category createCategory(Category category) {
        Category categoryInDb = this.categoryRepository.findByName(category.getName());
        if(categoryInDb != null){
            throw new SuchanaApiException("Category already exists with the name: " + category.getName(), 409);
        }
        return this.categoryRepository.save(category);
    }
}
