package com.springboot.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @GetMapping("/logout")
    public String logoutPage(){
        return "/logout";
    }
}
