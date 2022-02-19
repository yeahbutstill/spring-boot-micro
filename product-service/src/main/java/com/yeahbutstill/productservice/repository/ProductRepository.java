package com.yeahbutstill.productservice.repository;

import com.yeahbutstill.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
