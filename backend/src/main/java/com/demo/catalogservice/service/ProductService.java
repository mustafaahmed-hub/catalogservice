package com.demo.catalogservice.service;

import com.demo.catalogservice.config.RestTempCallConfig;
import com.demo.catalogservice.dto.ProductDescDto;
import com.demo.catalogservice.dto.ShipNodeItemDto;
import com.demo.catalogservice.exception.ProductNotFoundException;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.model.ProductDescription;
import com.demo.catalogservice.repository.CategoryRepository;
import com.demo.catalogservice.repository.ProductDescriptionRepository;
import com.demo.catalogservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        String categoryId = product.getCategoryId();
//        for (String id : categoryId) {
//            Optional<Category> category = categoryRepository.findById(id);
//            if (category.isPresent()) {
////                List<CategoryProducts> products = category.get().getProducts();
//                if (products==null) {
//                    log.info("inside the null product list block");
//                    List<CategoryProducts> newProducts = new ArrayList<>();
//                    CategoryProducts categoryProduct = new CategoryProducts();
//                    categoryProduct.setId(product.getId());
////                    categoryProduct.setCategoryId(product.getCategoryId());
//                    categoryProduct.setDescId(product.getDescId());
//                    categoryProduct.setPrice(product.getPrice());
//                    categoryProduct.setName(product.getName());
//                    categoryProduct.setImageUrl(product.getImageUrl());
//                    newProducts.add(categoryProduct);
////                    category.get().setProducts(newProducts);
//                    categoryRepository.save(category.get());
//
//                } else {
//                    log.info("inside block with existing product list values");
//                    CategoryProducts categoryProduct = new CategoryProducts();
//                    categoryProduct.setId(product.getId());
//                    categoryProduct.setCategoryId(product.getCategoryId());
//                    categoryProduct.setDescId(product.getDescId());
//                    categoryProduct.setPrice(product.getPrice());
//                    categoryProduct.setName(product.getName());
//                    categoryProduct.setImageUrl(product.getImageUrl());
//
//                    products.add(categoryProduct);
//                    category.get().setProducts(products);
//                    categoryRepository.save(category.get());
//                }
//            }
//        }
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
        return productRepository.save(product);
    }


    public void deleteProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException(exception_msg + " " + id);
        }
        productRepository.delete(product.get());
    }


    public Product getProductByName(String name) {
        Product product = productRepository.findByName(name);
        return product;
    }

    public List<Product> getProductByCategoryId(String id) {
        List<Product> products = productRepository.findByCategoryId(id);
        return products;
    }

    public ProductDescDto getProductDescription(String pid, String id) {
        ShipNodeItemDto shipNodeItemDto = restTemplate.getForObject(config.getInventoryService()+"/"+pid, ShipNodeItemDto.class);
        Optional<ProductDescription> tmp = productDescriptionRepository.findById(id);
        ProductDescription productDescription = tmp.get();
        ProductDescDto productDescDto = new ProductDescDto();
        productDescDto.setProductAvailability(shipNodeItemDto.getQuantityAvailable());
        productDescDto.setProductDescription(productDescription.getDescription());
        productDescDto.setProductId(productDescription.getId());
        productDescDto.setProductPrice(productDescription.getPrice());
        productDescDto.setProductName(productDescription.getName());
        productDescDto.setProductWeight(productDescription.getWeight());
        return productDescDto;

    }
}
