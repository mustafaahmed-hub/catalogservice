package com.demo.catalogservice.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String s) {
        super(s);
    }
}
