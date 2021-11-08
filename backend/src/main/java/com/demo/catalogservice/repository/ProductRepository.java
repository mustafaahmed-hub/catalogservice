package com.demo.catalogservice.repository;

import com.demo.catalogservice.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository  extends CassandraRepository<Product,String> {
}
