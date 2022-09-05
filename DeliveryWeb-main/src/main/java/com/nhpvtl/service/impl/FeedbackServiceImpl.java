/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.repository.FeedbackRepository;
import com.nhpvtl.service.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getFeedbacks(int shipperId) {
        return this.feedbackRepository.getFeedbacks(shipperId);
    }

    @Override
    public Shipper getShipperById(int shipperId) {
        return this.feedbackRepository.getShipperById(shipperId);
    }

    @Override
    public Feedback addFeedback(String comment, int shipperId) {
        return this.feedbackRepository.addFeedback(comment, shipperId);
    }
}
