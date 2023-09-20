package com.billing.finalproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Products {
    public Products() {
        super();
    }
    @Column (name = "id")
    private int id;
    @Column (name = "description")
    private String description;
    @Column (name = "code")
    private String code;
    @Column (name = "stock")
    private int stock;
    @Column (name = "price")
    private double price;
}