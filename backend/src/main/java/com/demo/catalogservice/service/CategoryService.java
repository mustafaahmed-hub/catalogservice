package com.demo.catalogservice.service;

import com.demo.catalogservice.exception.CategoryNotFoundException;
import com.demo.catalogservice.exception.ProductNotFoundException;
import com.demo.catalogservice.model.Category;
import com.demo.catalogservice.model.CategoryProducts;
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
    String exception_msg = "Category not found with id - ";
    public List<CategoryProducts> getProductsByCategoryId(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new CategoryNotFoundException(exception_msg+id);

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
        log.info("parent category is - "+ parent);
        if(parent!=null){

            Optional<Category> parentCategory = categoryRepository.findById(parent);
            if(parentCategory.isEmpty()){
                log.info("parent category Id is not correct");
            }else{
                List<String> children = parentCategory.get().getChildCategoryId();
                children.add(category.getCategoryId());
                parentCategory.get().setChildCategoryId(children);
            }
        }
        log.info("before inserting to db");
        return categoryRepository.save(category);
//        log.info("after inserting to db");
    }

    public void deleteCategoryById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
//            throw category not found exception
        }
        categoryRepository.delete(category.get());
    }
}
