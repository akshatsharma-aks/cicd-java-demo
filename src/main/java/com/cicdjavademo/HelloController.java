package com.cicdjavademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
//        return "CI/CD Pipeline Working Successfully!";
        return "Webhook Working!, Auto Build Working Final!";
    }
}
