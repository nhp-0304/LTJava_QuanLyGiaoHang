/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.ShipperByAdminRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class ShipperByAdminRepositoryImpl implements ShipperByAdminRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Shipper> getShippers(Map<String, String> params, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Shipper> q = b.createQuery(Shipper.class);
        Root root = q.from(Shipper.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("licensePlate").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String cityId = params.get("cityId");
            if (cityId != null) {
                Predicate p = b.equal(root.get("cityId"), Integer.parseInt(cityId));
                predicates.add(p);
            }

            String accId = params.get("accountId");
            if (accId != null) {
                Predicate p = b.equal(root.get("accountId"), Integer.parseInt(accId));
                predicates.add(p);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("id")));

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
    public int countShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Shipper");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteShipper(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {
            Shipper sp = s.get(Shipper.class, id);
            s.delete(sp);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addShipper(Shipper sp) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(sp);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<UserAccount> q = b.createQuery(UserAccount.class);
        Root root = q.from(UserAccount.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("userName").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);

        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }
}
