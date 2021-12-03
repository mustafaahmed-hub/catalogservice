package com.demo.catalogservice.controller;

import com.demo.catalogservice.dto.ProductDescDto;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.model.ProductDescription;
import com.demo.catalogservice.service.GraphQLProvider;
import com.demo.catalogservice.service.ProductService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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
        List<Product> list = new ArrayList<>();
        list.add(product);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //get product by name
    @GetMapping("name/{name}")
    public ResponseEntity getProductByName(@PathVariable String name){
        Product product = productservice.getProductByName(name);
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
    //get product description
    @GetMapping("description/{pid}")
    public ResponseEntity getProductDescription(@PathVariable String pid){
        ProductDescDto productDescDto = productservice.getProductDescription(pid);
        return ResponseEntity.status(HttpStatus.OK).body(productDescDto);
    }
    //create product description
    @PostMapping("/description")
    public ResponseEntity createProductDescription(@RequestBody ProductDescription productDescription){
        productservice.createProductDescription(productDescription);
        return ResponseEntity.status(HttpStatus.OK).body("Product Description created");
    }
    @PutMapping("description/{id}")
    public ResponseEntity updateProductDescription(@PathVariable String id ,@RequestBody ProductDescription productDescription){
        ProductDescription updatedBody = productservice.updateProductDescriptionById(id,productDescription);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBody);
    }
    //delete product description
    @DeleteMapping("/description/{id}")
    public ResponseEntity deleteProductDescription(@PathVariable String id){
        productservice.deleteProductDescriptionById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Description deleted");
    }


}
