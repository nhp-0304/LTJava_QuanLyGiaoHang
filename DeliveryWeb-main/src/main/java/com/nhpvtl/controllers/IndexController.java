/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.service.AccountService;
import com.nhpvtl.service.CityService;
import com.nhpvtl.service.OrderShipService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private CityService cityService;

    @Autowired
    private AccountService accountService;

//    LenVo
    @Autowired
    private Cloudinary cloudinary;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        return "index";
    }

    @ModelAttribute
    public void commonAttrCity(Model model) {
        model.addAttribute("cities", this.cityService.getCities());
    }

    @ModelAttribute
    public void commonAttrAcc(Model model) {
        model.addAttribute("accs", this.accountService.getAccs());
    }

//    LenVo
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(@ModelAttribute("useraccount") UserAccount userAccount) {
        try {
            cloudinary.uploader().upload(userAccount.getUserAvatar().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "index";
    }
}
