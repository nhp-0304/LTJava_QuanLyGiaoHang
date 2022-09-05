/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.controllers;

import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.service.FeedbackService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiFeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    
    @GetMapping("/shipperbycustomer/{shipperId}/feedbacks")
    public ResponseEntity<List<Feedback>> getFeedbacks(@PathVariable(value = "shipperId") int id) {
        return new ResponseEntity<>(this.feedbackService.getFeedbacks(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "/shipperbycustomer/{shipperId}/feedbacks",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Feedback> addFeedback(@RequestBody Map<String, String> params) {
        String comment = params.get("comment");
        int shipperId = Integer.parseInt(params.get("shipperId"));
        
        Feedback f = this.feedbackService.addFeedback(comment, shipperId);
        
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }
}
