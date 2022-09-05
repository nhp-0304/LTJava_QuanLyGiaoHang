/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Discount;
import com.nhpvtl.repository.DiscountRepository;
import com.nhpvtl.service.DiscountService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> getDiscounts(Map<String, String> params, int page) {
        return this.discountRepository.getDiscounts(params, page);
    }

    @Override
    public boolean addDiscount(Discount d) {
        return this.discountRepository.addDiscount(d);
    }

    @Override
    public boolean deleteDiscount(int id) {
        return this.discountRepository.deleteDiscount(id);
    }

    @Override
    public int countDiscount() {
        return this.discountRepository.countDiscount();
    }
}
