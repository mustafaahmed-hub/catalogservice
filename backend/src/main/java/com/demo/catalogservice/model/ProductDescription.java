package com.demo.catalogservice.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.UUID;

@Data
public class ProductDescription {
    private UUID id;
    private String description;
    private Double weight;

//    private Long size;

}
