package com.demo.catalogservice.model;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Table
public class Category {
    @PrimaryKey(value = "category_id")
    private String categoryId;

    @CassandraType(type = CassandraType.Name.TEXT)
    @Column("category_name")
    private String categoryName;
    @CassandraType(type = CassandraType.Name.TEXT)
    @Column("parent_category_id")
    private String parentCategoryId;

    @CassandraType(type = CassandraType.Name.LIST , typeArguments = CassandraType.Name.TEXT)
    @Column("child_category_id")
    private List<String> childCategoryId;

    @Column
    private List<CategoryProducts> products;
}
