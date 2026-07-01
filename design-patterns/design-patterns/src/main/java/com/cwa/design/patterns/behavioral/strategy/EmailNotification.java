package com.cwa.design.patterns.behavioral.strategy;

import org.springframework.stereotype.Service;

@Service
public class EmailNotification
        implements NotificationStrategy {

    @Override
    public void send(String message) {

        System.out.println("Email Sent : " + message);
    }
}
