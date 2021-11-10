package com.demo.catalogservice.repository;

import com.demo.catalogservice.model.ProductDescription;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductDescriptionRepository extends CassandraRepository<ProductDescription, String> {
}
