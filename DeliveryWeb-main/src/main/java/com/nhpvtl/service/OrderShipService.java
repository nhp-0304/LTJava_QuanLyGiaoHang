/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.Orders;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface OrderShipService {

    List<Orders> getOrders(Map<String, String> params, int page);

    Orders getById(int id);

    boolean addOrUpdate(Orders orders);

    int countOrders();
    
    List<Orders> getOrders(String kw, int page);
    
    List<Object[]> countOrdersByShipper();
    
    List<Object[]> revenueStats(int quarter, int year);
    
    List<Object[]> frequencyStats(int month, int year);
    
    Orders getOrderById(int orderId);
}
