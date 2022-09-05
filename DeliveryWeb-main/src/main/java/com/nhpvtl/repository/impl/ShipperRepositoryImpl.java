/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Customer;
import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.ShipperRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class ShipperRepositoryImpl implements ShipperRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public Shipper getShipperById(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Shipper.class, shipperId);
    }

    @Override
    public int countShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From UserAccount Where userRole = 'ROLE_SHIPPER' and userActive = '1'");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<UserAccount> getShipperByCus(String kw, int page) {

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

        Predicate pre = builder.equal(root.get("userActive"), Boolean.TRUE);
        query = query.where(pre);

        Predicate p1 = builder.like(root.get("userRole").as(String.class), "ROLE_SHIPPER");
        query = query.where(p1);

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
    public UserAccount getShipperByAccountId(int accountId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(UserAccount.class, accountId);
    }

    @Override
    public List<Shipper> getShipper(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Shipper> query = builder.createQuery(Shipper.class);
        Root root = query.from(Shipper.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("licensePlate").as(String.class),
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

        return q.getResultList();    }

    @Override
    public int countShip() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Shipper");

        return Integer.parseInt(q.getSingleResult().toString());    }

}
