/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.ShipperRepository;
import com.nhpvtl.service.ShipperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ShipperServiceImpl implements ShipperService {

    @Autowired
    private ShipperRepository shipperReposiroty;

    @Override
    public Shipper getShipperById(int shipperId) {
        return this.shipperReposiroty.getShipperById(shipperId);
    }

    @Override
    public int countShipper() {
        return this.shipperReposiroty.countShipper();
    }

    @Override
    public List<UserAccount> getShipperByCus(String kw, int page) {
        return this.shipperReposiroty.getShipperByCus(kw, page);
    }

    @Override
    public UserAccount getShipperByAccountId(int accountId) {
        return this.shipperReposiroty.getShipperByAccountId(accountId);
    }

    @Override
    public List<Shipper> getShipper(String kw, int page) {
        return this.shipperReposiroty.getShipper(kw, page);
    }

    @Override
    public int countShip() {
        return this.shipperReposiroty.countShip();
    }
}
