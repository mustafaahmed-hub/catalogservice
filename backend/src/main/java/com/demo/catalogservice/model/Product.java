package com.demo.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "test_product")
public class Product {
    @PrimaryKeyColumn(name = "category_id" ,type = PrimaryKeyType.PARTITIONED)
    private String categoryId;
    @PrimaryKeyColumn(value = "product_id" , type =PrimaryKeyType.CLUSTERED)
    private String id;
    @PrimaryKeyColumn(name = "product_name" ,type = PrimaryKeyType.CLUSTERED)
    private String name;
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private double price;
    @Column("image_url")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String imageUrl;


}
