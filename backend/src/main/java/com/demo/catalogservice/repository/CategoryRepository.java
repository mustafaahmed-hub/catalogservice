package com.demo.catalogservice.repository;

import com.demo.catalogservice.model.Category;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CassandraRepository<Category, String> {

}
