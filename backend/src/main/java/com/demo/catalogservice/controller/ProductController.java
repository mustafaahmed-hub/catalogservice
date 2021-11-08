package com.demo.catalogservice.controller;

import com.demo.catalogservice.service.GraphQLProvider;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    GraphQLProvider graphQLProvider;
    @PostMapping
    public ResponseEntity<Object> getAllProduct(@RequestBody String query){
        ExecutionResult executionResult = graphQLProvider.graphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
}
