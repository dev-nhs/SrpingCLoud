package com.devnhs.springcloud.msvc_items.clients;

import com.devnhs.springcloud.msvc_items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient( name = "msvc-products")
public interface ProductFeignClient {

    @GetMapping("/api/products")
    List<Product> findAll();

    @GetMapping("/api/products/{id}")
    Product details(@PathVariable Long id);
}
