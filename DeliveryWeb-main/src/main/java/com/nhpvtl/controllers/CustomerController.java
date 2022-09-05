/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.service.ShipperService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/customer")
@PropertySource("classpath:messages.properties")
public class CustomerController {

    @Autowired
    private ShipperService shipperService;

    @GetMapping("/shipperlist")
    public String shipperList(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shippers", this.shipperService.getShipperByCus(kw, page));
        model.addAttribute("shipperCounter", this.shipperService.countShipper());

        return "shipperlist";
    }

    @GetMapping("/shipperlist/shipperdetail/{accountId}")
    public String shipperDetail(Model model, @PathVariable(value = "accountId") int accountId) {
        model.addAttribute("shipper", this.shipperService.getShipperByAccountId(accountId));

        return "shipperdetail";
    }

    @GetMapping("/shipperbycustomer")
    public String shipperListByCustomer(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shippers2", this.shipperService.getShipper(kw, page));
        model.addAttribute("shipperCounter2", this.shipperService.countShip());

        return "shipperbycustomer";
    }

    @GetMapping("/shipperbycustomer/shipperfeedbackbycustomer/{shipperId}")
    public String shipperDetailByCustomer(Model model, @PathVariable(value = "shipperId") int shipperId) {
        model.addAttribute("shipper2", this.shipperService.getShipperById(shipperId));

        return "shipperfeedbackbycustomer";
    }

    @GetMapping("/infocustomer")
    public String infoCustomer() {

        return "infocustomer";
    }
    
    @GetMapping("/makeorder")
    public String makeOrder() {
        
        return "makeorder";
    }
}
