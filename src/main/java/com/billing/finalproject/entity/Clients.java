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

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
