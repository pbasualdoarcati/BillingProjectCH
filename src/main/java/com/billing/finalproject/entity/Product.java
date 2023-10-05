package com.billing.finalproject.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "products")
public class Product {
    public Product() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private String code;
    private Long stock;
    private Double price;

    @OneToMany(mappedBy = "product")
    private List<InvoiceDetails> invoiceDetails;

    public Product(Long id, String description, String code, Long stock, Double price) {
        this.productId = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public Long getId() {
        return productId;
    }

    public void setId(Long id) {
        this.productId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}