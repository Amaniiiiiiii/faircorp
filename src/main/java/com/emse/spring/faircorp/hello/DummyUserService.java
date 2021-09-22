package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{

    @Autowired
    GreetingService greetingService;

    @Override
    public void greetAll() {
        String[] strs = new String[]{"Elodie","Charles"};
        for (int i = 0; i < strs.length; i++) {
            greetingService.greet(strs[i]);
        }
    }
}
