package com.devnhs.springcloud.msvc_products.controllers;

import com.devnhs.springcloud.msvc_products.entities.Product;
import com.devnhs.springcloud.msvc_products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) {
        Optional<Product> productOptinal = productService.findById(id);

        if(productOptinal.isPresent()){
            return ResponseEntity.ok(productOptinal.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

}
