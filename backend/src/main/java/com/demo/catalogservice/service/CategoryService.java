package com.demo.catalogservice.service;

import com.demo.catalogservice.exception.ProductNotFoundException;
import com.demo.catalogservice.model.Category;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
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
        String parent = category.getParentCategoryId();
        if(!parent.isEmpty()){
            Optional<Category> category1 = categoryRepository.findById(parent);
            if(category1.isEmpty()){
                log.info("parent category Id is not correct");
            }else{
                List<String> children = category1.get().getChildCategoryId();
                children.add(parent);
                category1.get().setChildCategoryId(children);
            }
        }
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
