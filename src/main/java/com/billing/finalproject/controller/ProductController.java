package com.billing.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.billing.finalproject.entity.Product;
import com.billing.finalproject.response.ResourceNotFoundException;
import com.billing.finalproject.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Get a product by id", description = "Get a product by id", tags = { "Product" })
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            throw new ResourceNotFoundException("Product not found");
        }
    }

    @Operation(summary = "Get all products", description = "Get all products", tags = { "Product" })
    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Products not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Save a product", description = "Save a product", tags = { "Product" })
    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Product> saveProduct(@RequestBody Product client) {
        try {
            Product createdProduct = productService.save(client);
            return ResponseEntity.ok(createdProduct);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Product not created");
        }
    }
}
