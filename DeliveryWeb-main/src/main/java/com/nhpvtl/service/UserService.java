/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.UserAccount;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DELL
 */
public interface UserService extends UserDetailsService{
    List<UserAccount> getUserbyUserName (Map<String, String> params);
    boolean addUserAccount(UserAccount userAccount);
    boolean addShipperAccount(UserAccount userAccount);
}
