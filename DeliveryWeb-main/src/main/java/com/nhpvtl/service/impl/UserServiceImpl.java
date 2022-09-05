/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.UserRepository;
import com.nhpvtl.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEndcoder;

//    LenVo
    @Autowired
    private Cloudinary cloudinary;

    public UserAccount getUserbyUserName(String userName) {
        return this.userRepository.getUserbyUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserAccount u = this.getUserbyUserName(userName);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid user name");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));

        return new User(u.getUserName(), u.getUserPassword(), authorities);
    }

    @Override
    public List<UserAccount> getUserbyUserName(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUserAccount(UserAccount userAccount) {
//        String pass = userAccount.getUserPassword();
//        userAccount.setUserPassword(this.passwordEndcoder.encode(pass));
//        userAccount.setUserActive(Boolean.TRUE);
//        userAccount.setUserRole(UserAccount.CUSTOMER);
//
//        return this.userRepository.addUserAccount(userAccount);
        String pass = userAccount.getUserPassword();
        String avatar = userAccount.getUserAvatar();
        userAccount.setUserPassword(this.passwordEndcoder.encode(pass));
        userAccount.setUserActive(Boolean.TRUE);
        userAccount.setUserRole(UserAccount.CUSTOMER);
        if (!userAccount.getFile().isEmpty()) {
            Map r = null;
            try {
                r = this.cloudinary.uploader().upload(userAccount.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                userAccount.setUserAvatar((String) r.get("secure_url"));
                return this.userRepository.addUserAccount(userAccount);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (r != null) {
                userAccount.setUserAvatar((String) r.get("secure_url"));
            } else {
                userAccount.setUserAvatar(avatar);
            }
        }
        return false;
    }

    @Override
    public boolean addShipperAccount(UserAccount userAccount) {
//        String pass = userAccount.getUserPassword();
//        userAccount.setUserPassword(this.passwordEndcoder.encode(pass));
//        userAccount.setUserActive(Boolean.TRUE);
//        userAccount.setUserRole(UserAccount.SHIPPER);
//        
//        return this.userRepository.addUserAccount(userAccount);
        String pass = userAccount.getUserPassword();
        String avatar = userAccount.getUserAvatar();
        userAccount.setUserPassword(this.passwordEndcoder.encode(pass));
        userAccount.setUserActive(Boolean.TRUE);
        userAccount.setUserRole(UserAccount.SHIPPER);
        if (!userAccount.getFile().isEmpty()) {
            Map r = null;
            try {
                r = this.cloudinary.uploader().upload(userAccount.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                userAccount.setUserAvatar((String) r.get("secure_url"));
                return this.userRepository.addShipperAccount(userAccount);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (r != null) {
                userAccount.setUserAvatar((String) r.get("secure_url"));
            } else {
                userAccount.setUserAvatar(avatar);
            }
        }
        return false;
    }
}
