package com.billing.finalproject.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.billing.finalproject.entity.Products;

import jakarta.persistence.EntityManager;

@Service
public class DaoFactory {
    
    @Autowired
    private SessionFactory sessionFactory;

    public DaoFactory(EntityManager entityManager) {
        this.sessionFactory = entityManager.unwrap(SessionFactory.class);
    } 

    public void create(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    } 

    public void update(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }
    public List<Products> getAllProducts() {
        Session session = sessionFactory.openSession();
        List<Products> products = session.createQuery("from Products", Products.class).getResultList();
        session.close();
        return products;
    }
    public Products getProductById(int id) {
        Session session = sessionFactory.openSession();
        Products product = session.get(Products.class, id);
        session.close();
        return product;
    }
}
