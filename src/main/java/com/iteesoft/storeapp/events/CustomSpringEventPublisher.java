package com.iteesoft.storeapp.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {

    private ApplicationEventPublisher publisher;

    public void publishCustomEvent(String message) {
        System.out.println("Publishing custom event: " + message);
        CustomSpringEvent event = new CustomSpringEvent(this, message);
        publisher.publishEvent(event);
    }

}
