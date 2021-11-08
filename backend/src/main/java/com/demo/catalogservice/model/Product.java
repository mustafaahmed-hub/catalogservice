package com.demo.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private double price;
    private String imageUrl;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductDescription description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
