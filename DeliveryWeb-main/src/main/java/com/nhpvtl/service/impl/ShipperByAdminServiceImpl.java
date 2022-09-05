/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.ShipperByAdminRepository;
import com.nhpvtl.service.ShipperByAdminService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ShipperByAdminServiceImpl implements ShipperByAdminService {

    @Autowired
    private ShipperByAdminRepository shipperByAdminRepository;

    @Override
    public List<Shipper> getShippers(Map<String, String> params, int page) {
        return this.shipperByAdminRepository.getShippers(params, page);
    }

    @Override
    public int countShipper() {
        return this.shipperByAdminRepository.countShipper();
    }

    @Override
    public boolean addShipper(Shipper sp) {
        sp.setAvatarShipper("https://res.cloudinary.com/lenvo1202/image/upload/v1661905096/w7destutdjoadseneyra.png");
                
        return this.shipperByAdminRepository.addShipper(sp);
    }

    @Override
    public boolean deleteShipper(int id) {
        return this.shipperByAdminRepository.deleteShipper(id);
    }

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        return this.shipperByAdminRepository.getAccounts(params, page);
    }
}
