package com.demo.catalogservice.repository;

import com.demo.catalogservice.model.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository  extends CassandraRepository<Product,String> {
    @Override
    @AllowFiltering
    Optional<Product> findById(String s);

    @AllowFiltering
    Product findByName(String name);

    @Query("select * from main.test_product where category_id =?0")
    List<Product> findByCategoryId(String id);
}
