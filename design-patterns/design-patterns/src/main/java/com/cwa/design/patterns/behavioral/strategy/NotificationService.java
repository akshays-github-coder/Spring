package com.cwa.design.patterns.behavioral.strategy;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {

    private final Map<String, NotificationStrategy> strategies;

    public NotificationService(
            Map<String, NotificationStrategy> strategies) {

        this.strategies = strategies;
    }

    public void send(
            String type,
            String message) {

        NotificationStrategy strategy =
                strategies.get(type);

        strategy.send(message);
    }
}
