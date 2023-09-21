package com.billing.finalproject.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne 
    private Clients client;
    public Clients getClient() {
        return client;
    }
    
    @OneToMany 
    @Column (name = "invoice_detail_id")
    private InvoiceDetails[] invoiceDetails;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClient_id() {
        return client_id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public String getCreateAt() {
        return createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    
}
