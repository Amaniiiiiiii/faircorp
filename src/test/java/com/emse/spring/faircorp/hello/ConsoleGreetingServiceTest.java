package com.emse.spring.faircorp.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(OutputCaptureExtension.class)
class ConsoleGreetingServiceTest {
    @Test
    public void testGreeting(CapturedOutput output){
        GreetingService greetingService = new ConsoleGreetingService();
        greetingService.greet("Spring");
        Assertions.assertThat(output.getAll()).contains("Hello, Spring");
    }

}