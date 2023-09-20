package com.billing.finalproject.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class InvoiceDetails {
    public InvoiceDetails() {
        super();
    }
    @Column (name = "invoice_detail_id")
    private int invoiceDetailId;
    @Column (name = "invoice_id")
    private int invoiceId;
    @Column (name = "amount")
    private int amount;
    @Column (name = "product_id")
    private int productId;
    @Column (name = "price")
    private double price;

    
}
