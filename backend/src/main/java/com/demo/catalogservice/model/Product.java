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
@Table
public class Product {
    @PrimaryKey(value = "product_id")
    private String id;
    @Column("product_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;

    @CassandraType(type = CassandraType.Name.DOUBLE)
    private double price;
    @Column("image_url")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String imageUrl;
    @Column("description_id")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String descId;
    @Column("category_id")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String categoryId;

}
