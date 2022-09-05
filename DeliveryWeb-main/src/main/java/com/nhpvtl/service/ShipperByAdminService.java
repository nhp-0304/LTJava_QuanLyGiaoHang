/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ShipperByAdminService {

    List<Shipper> getShippers(Map<String, String> params, int page);

    int countShipper();

    boolean addShipper(Shipper sp);

    boolean deleteShipper(int id);
    
    List<UserAccount> getAccounts(Map<String, String> params, int page);
}
