/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Customer;
import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.repository.FeedbackRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class FeedbackRepositoryImpl implements FeedbackRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Feedback> getFeedbacks(int shipperId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Feedback> q = b.createQuery(Feedback.class);
        Root root = q.from(Feedback.class);
        q.select(root);

        q.where(b.equal(root.get("shipperId"), shipperId));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Shipper getShipperById(int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Shipper.class, shipperId);
    }

    @Override
    public Feedback addFeedback(String comment, int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Feedback f = new Feedback();
        f.setComment(comment);
        f.setShipperId(this.getShipperById(shipperId));
        f.setCustomerId(session.get(Customer.class, 1));

        session.save(f);

        return f;
    }
}
