package com.billing.finalproject.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "invoice")
public class Invoice {
    public Invoice() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long invoiceId;
    @Column(name = "create_at")
    private Date createdAt;
    @Column(name = "total")
    private Double total;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.MERGE)
    private List<InvoiceDetails> invoiceDetails;

    public Invoice(Long id, Client client, Date createdAt, double total) {
        this.invoiceId = id;
        this.client = client;
        this.createdAt = createdAt;
        this.total = total;
    }

    public Long getId() {
        return invoiceId;
    }

    public void setId(Long id) {
        this.invoiceId = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InvoiceDetails> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

}
