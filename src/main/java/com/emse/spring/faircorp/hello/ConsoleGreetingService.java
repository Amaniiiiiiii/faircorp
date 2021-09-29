package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ConsoleGreetingService implements GreetingService{

    private CycleService cycleService = null;

    public ConsoleGreetingService() {
    }

    @Autowired
    public ConsoleGreetingService(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @Override
    public void greet(String name) {
        System.out.println("Hello, "+name+"!");
    }
}
