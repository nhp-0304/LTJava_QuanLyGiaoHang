/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.pojo.Discount;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.service.DiscountService;
import com.nhpvtl.service.ShipperByAdminService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@Transactional
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private ShipperByAdminService shipperByAdminService;

    @GetMapping("/discountmanagebyadmin")
    public ResponseEntity<List<Discount>> list() {
        return new ResponseEntity<>(this.discountService.getDiscounts(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/discountmanagebyadmin/{discountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "discountId") int id) {
        this.discountService.deleteDiscount(id);
    }

    @GetMapping("/shippermanagebyadmin")
    public ResponseEntity<List<Shipper>> listShipper() {
        return new ResponseEntity<>(this.shipperByAdminService.getShippers(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/shippermanagebyadmin/{shipperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShipper(@PathVariable(value = "shipperId") int id) {
        this.shipperByAdminService.deleteShipper(id);
    }
}
