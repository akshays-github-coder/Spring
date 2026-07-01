package com.cwa.design.patterns.behavioral.strategy;

import org.springframework.stereotype.Service;

@Service
public class SmsNotification
        implements NotificationStrategy {

    @Override
    public void send(String message) {

        System.out.println(
                "SMS Sent : " + message);
    }
}