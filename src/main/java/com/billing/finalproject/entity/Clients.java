package com.billing.finalproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "CLIENTS")
public class Clients {
    public Clients() {
        super();
    }

    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "lastname")
    private String lastname;
    @Column (name = "docnumber")
    private String docnumber;



}
