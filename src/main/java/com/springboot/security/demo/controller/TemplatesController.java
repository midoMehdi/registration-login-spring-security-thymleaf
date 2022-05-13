package com.springboot.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

    @GetMapping("/")
    public String registrationPage(){
        return "/login";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @GetMapping("/home")
    public String homePage(){
        return "/home";
    }


}
