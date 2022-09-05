/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.OrdersDetail;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.OrderShipRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class OrderShipRepositoryImpl implements OrderShipRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Orders> getOrders(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Orders> q = b.createQuery(Orders.class);
        Root root = q.from(Orders.class);
        q.select(root);

        Query query = session.createQuery(q);
        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);

        }
        return query.getResultList();
    }

    @Override
    public Orders getById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Orders.class, id);
    }

    @Override
    public boolean addOrUpdate(Orders orders) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (orders.getId() > 0) {
                session.update(orders);
            } else {
                session.save(orders);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int countOrders() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Orders ");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Object[]> countOrdersByShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(Orders.class);
        Root rSp = q.from(Shipper.class);
        Root rUc = q.from(UserAccount.class);

        q.where(b.equal(rO.get("shipperId"), rSp.get("id")),
                b.equal(rSp.get("accountId"), rUc.get("id")));
        q.multiselect(rSp.get("id"), rUc.get("userFirstname"), rUc.get("userLastname"),
                b.count(rO.get("id")));
        q.groupBy(rSp.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueStats(int quarter, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(Orders.class);
        Root rOd = q.from(OrdersDetail.class);
        Root rSp = q.from(Shipper.class);
        Root rUc = q.from(UserAccount.class);

        q.where(b.equal(rOd.get("orderId"), rO.get("id")),
                b.equal(rO.get("shipperId"), rSp.get("id")),
                b.equal(rSp.get("accountId"), rUc.get("id")),
                b.equal(b.function("QUARTER", Integer.class, rO.get("shippedDate")), quarter),
                b.equal(b.function("YEAR", Integer.class, rO.get("shippedDate")), year));

        q.multiselect(rSp.get("id"), rUc.get("userFirstname"), rUc.get("userLastname"),
                b.sum(rOd.get("shipPrice")));
        q.groupBy(rSp.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> frequencyStats(int month, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rO = q.from(Orders.class);
        Root rSp = q.from(Shipper.class);
        Root rUc = q.from(UserAccount.class);

        q.where(b.equal(rO.get("shipperId"), rSp.get("id")),
                b.equal(rSp.get("accountId"), rUc.get("id")),
                b.equal(b.function("MONTH", Integer.class, rO.get("shippedDate")), month),
                b.equal(b.function("YEAR", Integer.class, rO.get("shippedDate")), year));

        q.multiselect(rSp.get("id"), rUc.get("userFirstname"), rUc.get("userLastname"),
                b.count(rO.get("id")));
        q.groupBy(rSp.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Orders> getOrders(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root root = query.from(Orders.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("shipName").as(String.class),
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
    public Orders getOrderById(int orderId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Orders.class, orderId);
    }
}
