/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.repository.OrderRepository;
import com.nhpvtl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addOrder(Orders o) {
        o.setShipStatus(Boolean.FALSE);
        o.setPaymentStatus(Boolean.FALSE);
        o.setShipPostalcode(0);
        
        return this.orderRepository.addOrder(o);
    }

}
