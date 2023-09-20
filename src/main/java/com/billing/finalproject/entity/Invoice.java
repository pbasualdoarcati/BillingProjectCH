package com.billing.finalproject.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Invoice {
    public Invoice() {
        super();
    }
    @Column (name = "id")
    private int id;
    @Column (name = "client_id")
    private int client_id;
    @Column (name = "create_at")
    private String createAt;
    @Column (name = "total")
    private double total;

}
