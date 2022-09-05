/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/shipper")
@PropertySource("classpath:messages.properties")
public class ShipperController {

    @GetMapping("/infoshipper")
    public String infoShipper() {

        return "infoshipper";
    }
    
    @GetMapping("/takeorder")
    public String takeOrder() {
        
        return "takeorder";
    }
}
