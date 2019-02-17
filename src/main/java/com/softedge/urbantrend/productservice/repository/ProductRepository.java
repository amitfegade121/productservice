package com.softedge.urbantrend.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.softedge.urbantrend.productservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
