package com.interview.test.controller.service;

import com.interview.test.entity.InterviewEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InterviewService {

    HashMap<String, InterviewEntity> interviewEntityHashMap = new HashMap<String, InterviewEntity>();

    public InterviewEntity getInterviewDetails(String id) {
        interviewEntityHashMap.put(id, new InterviewEntity("1", "Akshay", "", ""));
        return interviewEntityHashMap.get(id);
    }
}
