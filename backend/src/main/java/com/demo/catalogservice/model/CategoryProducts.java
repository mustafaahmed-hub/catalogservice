package com.demo.catalogservice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;
@Data
@UserDefinedType
public class CategoryProducts {
    @Column("product_id")
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
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.TEXT)
    private List<String> categoryId;

}
