package com.settle.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.settle.api.entity.Bill;
import com.settle.api.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImp implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserByEmail(String email) {
        
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email = :data", User.class);

        query.setParameter("data", email);

        List<User> users = query.getResultList();

        // assuming email id unique constrint in RDBMS is working
        return users.get(0);
    }

    @Override
    public User getUserWithRolesByEmail(String email) {

        TypedQuery<User> query = entityManager.createQuery("select u from User u JOIN FETCH u.roles where u.email = :data", User.class);

        query.setParameter("data", email);

        List<User> users = query.getResultList();

        // assuming email id unique constrint in RDBMS is working
        return users.get(0);
        
    }

    @Override
    @Transactional
    public void saveBill(Bill bill) {
        entityManager.persist(bill);
    }
    
}
