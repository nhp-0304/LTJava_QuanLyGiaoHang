/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhpvtl.repository;

import com.nhpvtl.pojo.Discount;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface DiscountRepository {

    List<Discount> getDiscounts(Map<String, String> params, int page);
    
    int countDiscount();

    boolean addDiscount(Discount d);

    boolean deleteDiscount(int id);
}
