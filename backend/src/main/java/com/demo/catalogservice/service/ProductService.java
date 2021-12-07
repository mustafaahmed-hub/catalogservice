package com.demo.catalogservice.service;

import com.demo.catalogservice.config.RestTempCallConfig;
import com.demo.catalogservice.dto.ProductDescDto;
import com.demo.catalogservice.dto.ShipNodeItemDto;
import com.demo.catalogservice.exception.ProductDescriptionNotFound;
import com.demo.catalogservice.exception.ProductNotFoundException;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.model.ProductDescription;
import com.demo.catalogservice.repository.CategoryRepository;
import com.demo.catalogservice.repository.ProductDescriptionRepository;
import com.demo.catalogservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ProductService {
    static String exception_msg = "Product not found with id -";
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDescriptionRepository productDescriptionRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RestTempCallConfig config;


    public void createProduct(Product product) {
        ProductDescription productDescription = new ProductDescription();
        productDescription.setId(product.getId());
        productDescription.setCategoryId(product.getCategoryId());
        productDescription.setPrice(product.getPrice());
        productDescription.setName(product.getName());
        productDescription.setImageUrl(product.getImageUrl());
        productDescriptionRepository.save(productDescription);
        productRepository.save(product);
    }

    public Product getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException(exception_msg + " " + id);
        }
        return product.get();
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product updateProductById(String id, Product product) {
        Optional<Product> productToUpdate = productRepository.findById(id);
        if (productToUpdate.isEmpty()) {
            throw new ProductNotFoundException(exception_msg + " " + id);
        }
        Optional<ProductDescription> tmp = productDescriptionRepository.findById(id);
        ProductDescription productDescription = tmp.get();
        productDescription.setCategoryId(product.getCategoryId());
        productDescription.setImageUrl(product.getImageUrl());
        productDescription.setPrice(product.getPrice());
        productDescription.setName(product.getName());
        productDescriptionRepository.save(productDescription);
        return productRepository.save(product);
    }


    public void deleteProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException(exception_msg + " " + id);
        }
        productRepository.delete(product.get());
        deleteProductDescriptionById(id);
    }


    public Product getProductByName(String name) {
        Product product = productRepository.findByName(name);
        return product;
    }

    public List<Product> getProductByCategoryId(String id) {
        List<Product> products = productRepository.findByCategoryId(id);
        return products;
    }

    public ProductDescDto getProductDescription(String pid)  {
        ResponseEntity<ShipNodeItemDto[]> objects = restTemplate.getForEntity(config.getInventoryService()+"/"+pid, ShipNodeItemDto[].class);
        Optional<ProductDescription> tmp = productDescriptionRepository.findById(pid);
        ProductDescription productDescription = tmp.get();
        ProductDescDto productDescDto = new ProductDescDto();
        ShipNodeItemDto[] array = objects.getBody();
        int totalQuantity =0;
        for(int i=0;i<array.length;i++){
            totalQuantity+=array[i].getQuantityAvailable();
        }
        System.out.println(totalQuantity);
        productDescDto.setProductAvailability(totalQuantity);
        productDescDto.setImageUrl(productDescription.getImageUrl());
        productDescDto.setProductDescription(productDescription.getDescription());
        productDescDto.setProductId(productDescription.getId());
        productDescDto.setProductPrice(productDescription.getPrice());
        productDescDto.setProductName(productDescription.getName());
        productDescDto.setProductWeight(productDescription.getWeight());
        productDescDto.setProductDimension(productDescription.getLength()+","+ productDescription.getBreadth()+","+productDescription.getHeight());
        return productDescDto;

    }
    // create product description
    public void createProductDescription(ProductDescription productDescription) {
        Product product = new Product(
                productDescription.getCategoryId(),
                productDescription.getId(),
                productDescription.getName(),
                productDescription.getPrice(),
                productDescription.getImageUrl());
        productRepository.save(product);
        productDescriptionRepository.save(productDescription);
    }
    //delete product description
    public void deleteProductDescriptionById(String id) {
        Optional<ProductDescription> productDescription = productDescriptionRepository.findById(id);
        if(productDescription.isPresent()){
            productDescriptionRepository.delete(productDescription.get());
        }
    }

//update the product description
    public ProductDescription updateProductDescriptionById(String id, ProductDescription productDescription) {
        Optional<ProductDescription> productDescription1 = productDescriptionRepository.findById(id);
        if(productDescription1.isEmpty()){
            throw new ProductDescriptionNotFound(exception_msg);
        }
        Product product = new Product(
                productDescription.getCategoryId(),
                productDescription.getId(),
                productDescription.getName(),
                productDescription.getPrice(),
                productDescription.getImageUrl());
        productRepository.save(product);
        return productDescriptionRepository.save(productDescription);
    }
}
