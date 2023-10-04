package com.billing.finalproject.entity;

import java.util.List;

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
    private Long id;
    private String name;
    private String lastname;
    private String docnumber;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

    public Client(Long id, String name, String lastname, String docnumber) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

}
