package com.billing.finalproject.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
    public Client() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientName;
    private String clientLastname;
    private String docnumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
    private List<Invoice> invoices;

    public Client(Long id, String name, String lastname, String docnumber) {
        this.clientId = id;
        this.clientName = name;
        this.clientLastname = lastname;
        this.docnumber = docnumber;
    }

    public Long getId() {
        return clientId;
    }

    public void setId(Long id) {
        this.clientId = id;
    }

    public String getName() {
        return clientName;
    }

    public void setName(String name) {
        this.clientName = name;
    }

    public String getLastname() {
        return clientLastname;
    }

    public void setLastname(String lastname) {
        this.clientLastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

}
