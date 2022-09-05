/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Discount;
import com.nhpvtl.repository.DiscountRepository;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class DiscountRepositoryImpl implements DiscountRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Discount> getDiscounts(Map<String, String> params, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Discount> q = b.createQuery(Discount.class);
        Root root = q.from(Discount.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("discountName").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String per = params.get("discountPercent");
            if (per != null) {
                Predicate p = b.equal(root.get("discountPercent"), Integer.parseInt(per));
                predicates.add(p);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("id")), b.desc(root.get("discountName")));

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
    public boolean addDiscount(Discount d) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(d);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDiscount(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {
            Discount d = s.get(Discount.class, id);
            s.delete(d);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int countDiscount() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Discount");

        return Integer.parseInt(q.getSingleResult().toString());
    }
}
