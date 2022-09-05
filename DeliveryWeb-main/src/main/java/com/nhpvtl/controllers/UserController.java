/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("useraccount", new UserAccount());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "useraccount") UserAccount userAccount) {
        String errMsg = "";
        if (userAccount.getUserPassword().equals(userAccount.getConfirmUserPassword())) {
            if (this.userDetailsService.addUserAccount(userAccount) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Error!";
            }
        } else {
            errMsg = "Mật khẩu chưa trùng khớp!";
        }

        model.addAttribute("errMsg", errMsg);

        return "register";
    }

    @GetMapping("/registershipper")
    public String registerShipperView(Model model) {
        model.addAttribute("shipperaccount", new UserAccount());
        return "registershipper";
    }

    @PostMapping("/registershipper")
    public String registerShipper(Model model, @ModelAttribute(value = "shipperaccount") UserAccount userAccount) {
        String errMsg = "";
        if (userAccount.getUserPassword().equals(userAccount.getConfirmUserPassword())) {
            if (this.userDetailsService.addShipperAccount(userAccount) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Error!";
            }
        } else {
            errMsg = "Mật khẩu chưa trùng khớp!";
        }

        model.addAttribute("errMsg", errMsg);

        return "registershipper";
    }
}
