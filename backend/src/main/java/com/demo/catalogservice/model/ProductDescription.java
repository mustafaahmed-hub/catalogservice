package com.demo.catalogservice.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Table
public class ProductDescription {
    @PrimaryKeyColumn(name = "desc_id",ordinal =0,type = PrimaryKeyType.PARTITIONED)
    private String id;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String description;
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private Double weight;


}
