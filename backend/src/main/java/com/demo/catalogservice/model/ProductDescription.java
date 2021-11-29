package com.demo.catalogservice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Table("product_description")
public class ProductDescription {
    @PrimaryKeyColumn(name = "product_id",type = PrimaryKeyType.PARTITIONED)
    private String id;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String description;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private Double weight;
    @Column("product_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private double price;
    @Column("image_url")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String imageUrl;
    @Column("category_id")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String categoryId;
    @Column("length")
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private Double length;
    @Column("breadth")
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private Double breadth;
    @Column("height")
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private Double height;

}
