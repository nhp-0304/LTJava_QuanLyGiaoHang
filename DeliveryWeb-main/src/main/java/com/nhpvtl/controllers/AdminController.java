/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.pojo.Discount;
import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.service.AccountService;
import com.nhpvtl.service.DiscountService;
import com.nhpvtl.service.ShipperByAdminService;
import com.nhpvtl.service.OrderShipService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:messages.properties")
public class AdminController {

    @Autowired
    private ShipperByAdminService shipperByAdminService;

    @Autowired
    private OrderShipService orderShipService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private Environment env;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/shippermanagebyadmin")
    public String adminListShippers(Model model, @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shipper", this.shipperByAdminService.getShippers(params, page));
        model.addAttribute("shipperCounter", this.shipperByAdminService.countShipper());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "shippermanagebyadmin";
    }

    @DeleteMapping("/shippermanagebyadmin/{shipperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShipper(@PathVariable(value = "shipperId") int id) {
        this.shipperByAdminService.deleteShipper(id);
    }

    @GetMapping("/shippermanagebyadmin")
    public String adminListShippersAdd(Model model) {
        model.addAttribute("shipper", new Shipper());

        return "shippermanagebyadmin";
    }

    @PostMapping("shippermanagebyadmin")
    public String addShipper(@ModelAttribute(value = "shipper") @Valid Shipper sp, BindingResult rs) {
        if (rs.hasErrors()) {
            return "shippermanagebyadmin";
        }

        if (this.shipperByAdminService.addShipper(sp) == true) {
            return "redirect:/";
        }
        return "shippermanagebyadmin";
    }

    @RequestMapping("/ordership")
    public String orderShip(Model model, @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        model.addAttribute("orderList", this.orderShipService.getOrders(kw, page));
        model.addAttribute("accountOrder", this.orderShipService.countOrders());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "ordership";
    }
    
    @GetMapping("/ordership/ordershipdetail/{orderId}")
    public String orderShipDetail(Model model, @PathVariable(value = "orderId") int orderId) {
        model.addAttribute("order", this.orderShipService.getOrderById(orderId));
        
        return "ordershipdetail";
    }

    @RequestMapping("/manageaccount")
    public String accountList(Model model, @RequestParam Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        model.addAttribute("account", this.accountService.getAccounts(kw, page));
        model.addAttribute("accountCounter", this.accountService.countAccounts());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "manageaccount";
    }

    @GetMapping("/manageaccount/addaccount")
    public String addAccountView(Model model) {
        model.addAttribute("addAccount", new UserAccount());
        return "addaccount";
    }

    @PostMapping("manageaccount/addaccount")
    public String addAccount(Model model, @ModelAttribute(value = "addAccount") @Valid UserAccount userAccount,
            BindingResult result) {

        if (result.hasErrors()) {
            return "manageaccount";
        }

        if (this.accountService.addAccount(userAccount) == true) {
            return "redirect:/";
        }

        return "manageaccount";
    }

    @RequestMapping("/discountmanagebyadmin")
    public String discountList(Model model, @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("discount", this.discountService.getDiscounts(params, page));
        model.addAttribute("discountCounter", this.discountService.countDiscount());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "discountmanagebyadmin";
    }

    @DeleteMapping("/discountmanagebyadmin/{discountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "discountId") int id) {
        this.discountService.deleteDiscount(id);
    }

    @GetMapping("/discountmanagebyadmin")
    public String discountListAdd(Model model) {
        model.addAttribute("discount", new Discount());

        return "discountmanagebyadmin";
    }

    @PostMapping("discountmanagebyadmin")
    public String addDiscount(@ModelAttribute(value = "discount") @Valid Discount d, BindingResult rs) {
        if (rs.hasErrors()) {
            return "discountmanagebyadmin";
        }

        if (this.discountService.addDiscount(d) == true) {
            return "redirect:/";
        }
        return "discountmanagebyadmin";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("spStats", this.orderShipService.countOrdersByShipper());

        return "stats";
    }

    @GetMapping("/revenuestats")
    public String revenuestats(Model model,
            @RequestParam(value = "quarter", defaultValue = "1") int quarter,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("revenueStats", this.orderShipService.revenueStats(quarter, year));

        return "revenuestats";
    }

    @GetMapping("/frequencystats")
    public String frequencystats(Model model,
            @RequestParam(value = "month", defaultValue = "1") int month,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("frequencyStats", this.orderShipService.frequencyStats(month, year));

        return "frequencystats";
    }
}
