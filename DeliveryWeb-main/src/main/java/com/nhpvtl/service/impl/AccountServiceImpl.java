/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.AccountRepository;
import com.nhpvtl.service.AccountService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        return this.accountRepository.getAccounts(params, page);
    }

    @Override
    public List<UserAccount> getAccs() {
        return this.accountRepository.getAccs();
    }

    @Override
    public List<UserAccount> getAccounts(String kw, int page) {
        return this.accountRepository.getAccounts(kw, page);
    }

    @Override
    public int countAccounts() {
        return this.accountRepository.countAccounts();
    }

    @Override
    public boolean addAccount(UserAccount ua) {
//        try {
//            Map r = this.cloudinary.uploader().upload(ua.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            ua.setUserAvatar((String) r.get("secure_url"));
//            ua.setUserActive(Boolean.TRUE);
//
//            return this.accountRepository.addAccount(ua);
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
        ua.setUserActive(Boolean.TRUE);
        return this.accountRepository.addAccount(ua);

    }
}
