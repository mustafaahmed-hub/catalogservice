package com.demo.catalogservice.controller;

import com.demo.catalogservice.model.Category;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.service.CategoryService;
import com.demo.catalogservice.service.GraphQLProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    GraphQLProvider graphQLProvider;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}/products")
    public ResponseEntity getProductsByCategoryId(@PathVariable String id){
        List<Product> res = categoryService.getProductsByCategoryId(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity getByCategoryId(@PathVariable String id){
        Category res = categoryService.fetchByCategoryId(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/category")
    public ResponseEntity addNewCategory(@RequestBody Category category){
        Category res = categoryService.addNewCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable String id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted");
    }

}