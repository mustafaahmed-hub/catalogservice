package com.demo.catalogservice.dto;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;
@Data
public class ShipNodeItemDto {


        private String productId;
        private int quantityAvailable;
        private UUID shipNodesId;
        private String shipNodesLocation;

}
