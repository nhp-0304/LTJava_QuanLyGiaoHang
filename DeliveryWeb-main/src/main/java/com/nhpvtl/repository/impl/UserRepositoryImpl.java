/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.UserRepository;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public UserAccount getUserbyUserName(String userName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM UserAccount u WHERE u.userName = :userName");
        q.setParameter("userName", userName);

        return (UserAccount) q.getSingleResult();
    }

    @Override
    public boolean addUserAccount(UserAccount userAccount) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userAccount);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean addShipperAccount(UserAccount userAccount) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userAccount);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }
}
