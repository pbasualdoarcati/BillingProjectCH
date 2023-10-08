package com.billing.finalproject.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.finalproject.entity.Product;
import com.billing.finalproject.service.ProductService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> saveProduct(@RequestBody Product client) {
        try {
            Product createdProduct = productService.save(client);
            return ResponseEntity.ok(createdProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
