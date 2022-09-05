/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.formatters;

import com.nhpvtl.pojo.UserAccount;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class UserAccountFormatter implements Formatter<UserAccount>{

    @Override
    public String print(UserAccount t, Locale locale) {
        return String.valueOf(t.getId());
       
    }

    @Override
    public UserAccount parse(String userAccountId, Locale locale) throws ParseException {
        UserAccount u = new UserAccount();
        u.setId(Integer.parseInt(userAccountId));
        
        return u;
    }
    
}
