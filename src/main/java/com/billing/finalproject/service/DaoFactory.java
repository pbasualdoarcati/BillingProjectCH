package com.billing.finalproject.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.billing.finalproject.entity.Product;

import jakarta.persistence.EntityManager;

@Service
public class DaoFactory {

    public DaoFactory (){
        
    }
    
    @Autowired
    private SessionFactory sessionFactory;

    public DaoFactory(EntityManager entityManager) {
        this.sessionFactory = entityManager.unwrap(SessionFactory.class);
    } 

    public void create(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
        session.close();
    } 

    public void update(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(object);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(object);
        session.getTransaction().commit();
        session.close();
    }
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Products", Product.class).getResultList();
        session.close();
        return products;
    }
    public Product getProductById(int id) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }
}
