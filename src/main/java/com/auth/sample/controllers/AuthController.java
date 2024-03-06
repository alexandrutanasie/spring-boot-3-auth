package com.auth.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {   
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
