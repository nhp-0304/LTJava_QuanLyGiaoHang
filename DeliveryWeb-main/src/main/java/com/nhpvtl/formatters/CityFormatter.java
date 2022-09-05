/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.formatters;

import com.nhpvtl.pojo.City;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class CityFormatter implements Formatter<City>{

    @Override
    public String print(City t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public City parse(String cityId, Locale locale) throws ParseException {
        City c = new City();
        c.setId(Integer.parseInt(cityId));

        return c;
    }
    
}
