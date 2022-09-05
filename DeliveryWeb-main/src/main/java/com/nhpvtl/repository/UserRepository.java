/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhpvtl.repository;

import com.nhpvtl.pojo.UserAccount;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    UserAccount getUserbyUserName(String userName);
    boolean addUserAccount(UserAccount userAccount);
    boolean addShipperAccount(UserAccount userAccount);
}
