package com.iteesoft.storeapp.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("Received spring event - " + event.getMessage());
    }
}
