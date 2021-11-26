package com.demo.catalogservice.dto;

import lombok.Data;

@Data
public class ProductDescDto {
    private String productId;
    private String productName;
    private Double productPrice;
    private Integer productAvailability;
    private Double productWeight;
    private String productDescription;
    private String productDimension;
}
