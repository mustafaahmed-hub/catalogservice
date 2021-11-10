package com.demo.catalogservice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Table
public class Category {
    @Id @PrimaryKeyColumn(name = "category_id",ordinal =0,type = PrimaryKeyType.PARTITIONED)
    private String categoryId;

    @CassandraType(type = CassandraType.Name.TEXT)
    private String categoryName;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String parentCategoryId;




    @CassandraType(type = CassandraType.Name.LIST , typeArguments = CassandraType.Name.TEXT)
    private List<String> childCategoryId;

    @CassandraType(type = CassandraType.Name.LIST , typeArguments = CassandraType.Name.TEXT)
    private List<Product> products;
}
