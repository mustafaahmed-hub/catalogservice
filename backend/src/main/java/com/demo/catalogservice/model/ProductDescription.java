package com.demo.catalogservice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Table("product_description")
public class ProductDescription {
    @PrimaryKeyColumn(name = "desc_id",ordinal =0,type = PrimaryKeyType.PARTITIONED)
    private String id;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String description;
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
}
