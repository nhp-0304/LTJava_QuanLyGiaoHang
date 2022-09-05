/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Discount;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<UserAccount> q = b.createQuery(UserAccount.class);
        Root root = q.from(UserAccount.class);
        q.select(root);

        Query query = s.createQuery(q);
        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public List<UserAccount> getAccs() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From UserAccount");
        return q.getResultList();
    }

    @Override
    public List<UserAccount> getAccounts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);
        Root root = query.from(UserAccount.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("userLastname").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            q.setFirstResult(start);
            q.setMaxResults(size);

        }

        return q.getResultList();
    }

    @Override
    public int countAccounts() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM UserAccount");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addAccount(UserAccount ua) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(ua);
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}
