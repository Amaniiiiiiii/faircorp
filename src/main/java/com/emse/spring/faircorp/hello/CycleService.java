package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CycleService {
//    加入老师提出的以下代码 会进入注入循环，启动失败
//    private final ConsoleGreetingService consoleGreetingService;
//
//    @Autowired
//    public CycleService(ConsoleGreetingService consoleGreetingService) {
//        this.consoleGreetingService = consoleGreetingService;
//    }

}
