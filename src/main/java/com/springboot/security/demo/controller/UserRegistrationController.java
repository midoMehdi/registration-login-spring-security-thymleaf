package com.springboot.security.demo.controller;

import com.springboot.security.demo.controller.dto.UserRegistrationDto;
import com.springboot.security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("user",userRegistrationDto);
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto){
        try {
            this.userService.save(userRegistrationDto);
            return "redirect:/registration?success";
        }
        catch (Exception e){
            return "redirect:/registration?failed";
        }

    }

    /*@GetMapping("/login")
    public String showLoginPage(){
        return "redirect:/login";
    }*/
}
