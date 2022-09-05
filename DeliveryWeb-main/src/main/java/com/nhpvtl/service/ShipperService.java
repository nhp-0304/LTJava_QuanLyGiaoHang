/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ShipperService {

    Shipper getShipperById(int shipperId);

    List<Shipper> getShipper(String kw, int page);

    int countShip();

    int countShipper();

    List<UserAccount> getShipperByCus(String kw, int page);

    UserAccount getShipperByAccountId(int accountId);
}
