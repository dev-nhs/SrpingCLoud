package com.devnhs.springcloud.msvc_products.repositories;

import com.devnhs.springcloud.msvc_products.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
