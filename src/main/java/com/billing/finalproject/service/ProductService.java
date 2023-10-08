package com.billing.finalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.finalproject.entity.Product;
import com.billing.finalproject.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public double getProductPrice(Long productId) {
        var product = productRepository.findById(productId);

        if (product.isEmpty())
            throw new RuntimeException();

        return product.get().getPrice();
    }

    public Long updateStockWithSell(Long productId, Long stock) {
        var product = productRepository.findById(productId);
        if (product.isEmpty())
            throw new RuntimeException();

        product.get().setStock(product.get().getStock() - stock);
        productRepository.save(product.get());

        return product.get().getStock(); // return stock after sell

    }
}
