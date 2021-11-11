package com.demo.catalogservice.service;

import com.demo.catalogservice.exception.ProductNotFoundException;
import com.demo.catalogservice.model.Category;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.repository.CategoryRepository;
import com.demo.catalogservice.repository.ProductDescriptionRepository;
import com.demo.catalogservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    static String exception_msg = "Product not found with id -";
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDescriptionRepository productDescriptionRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public void createProduct(Product product) {
        List<String> categoryId = product.getCategoryId();
        for(String id : categoryId){
            Optional<Category> category = categoryRepository.findById(id);
            if(category.isPresent()){
            List<Product> products = category.get().getProducts();
            products.add(product);
            category.get().setProducts(products);
            categoryRepository.save(category.get());
            }
        }
        productRepository.save(product);
    }

    public Product getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException(exception_msg+" "+id);
        }
        return product.get();
    }
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return  products;
    }

    public Product updateProductById(String id, Product product) {
        Optional<Product> productToUpdate = productRepository.findById(id);
        if(productToUpdate.isEmpty()){
            throw new ProductNotFoundException(exception_msg+" "+id);
        }
        return productRepository.save(product);
    }


    public void deleteProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException(exception_msg+" "+id);
        }
        productRepository.delete(product.get());
    }


}
