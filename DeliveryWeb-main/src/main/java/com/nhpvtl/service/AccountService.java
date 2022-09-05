/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.UserAccount;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface AccountService {

    List<UserAccount> getAccounts(Map<String, String> params, int page);

    List<UserAccount> getAccs();

    List<UserAccount> getAccounts(String kw, int page);
    
    int countAccounts();
    
    boolean addAccount(UserAccount ua);
}
