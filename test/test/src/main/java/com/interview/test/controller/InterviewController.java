package com.interview.test.controller;

import com.interview.test.controller.service.InterviewService;
import com.interview.test.entity.InterviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @GetMapping("/interview/{id}")
    public InterviewEntity interview(@PathVariable String id) {
        return interviewService.getInterviewDetails(id);
    }
}
