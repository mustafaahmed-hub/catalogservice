package com.demo.catalogservice.service;

import com.demo.catalogservice.exception.ProductNotFoundException;
import com.demo.catalogservice.model.Category;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getProductsByCategoryId(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            //throw category not found exception
            return null;
        }else{
            return category.get().getProducts();
        }
    }

    public Category fetchByCategoryId(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            //throw category not found exception
            return null;
        }else{
            return category.get();
        }
    }

    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
//            throw category not found exception
        }
        categoryRepository.delete(category.get());
    }
}
