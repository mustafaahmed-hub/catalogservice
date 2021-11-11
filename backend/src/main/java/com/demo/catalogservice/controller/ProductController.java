package com.demo.catalogservice.controller;

import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.service.GraphQLProvider;
import com.demo.catalogservice.service.ProductService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    GraphQLProvider graphQLProvider;
    @Autowired
    private ProductService productservice;

    @PostMapping("/graphql")
    public ResponseEntity<Object> getAllProduct(@RequestBody String query){
        ExecutionResult executionResult = graphQLProvider.graphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
    //create a product
    @PostMapping("/")
    public ResponseEntity createProduct(@RequestBody Product product){
        productservice.createProduct(product);
        return  ResponseEntity.status(HttpStatus.CREATED).body("created product");
    }
    //get product by id
    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable String id){
        Product product = productservice.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    //get all products
    @GetMapping("/")
    public ResponseEntity getAllProduct(){
        List<Product> products = productservice.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    //update the product by id
    @PutMapping("/{id}")
    public ResponseEntity updateProductById(@PathVariable String id, @RequestBody Product product){
        Product updatedProduct = productservice.updateProductById(id,product);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedProduct);
    }
    //deleting a product
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable String id){
        productservice.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }


}
