/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.pojo.Shipper;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface FeedbackService {

    List<Feedback> getFeedbacks(int shipperId);

    Feedback addFeedback(String comment, int shipperId);

    Shipper getShipperById(int shipperId);
}
