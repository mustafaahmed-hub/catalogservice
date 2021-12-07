package com.demo.catalogservice.exception;

public class ProductDescriptionNotFound extends RuntimeException {
    public ProductDescriptionNotFound(String msg){ super(msg); }
}
