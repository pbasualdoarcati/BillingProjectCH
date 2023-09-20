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
    public int getInvoiceDetailId() {
        return invoiceDetailId;
    }
    public void setInvoiceDetailId(int invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }
    public int getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    
}
