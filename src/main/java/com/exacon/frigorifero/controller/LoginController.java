package com.exacon.frigorifero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showlog() {
        return "login-page";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "login-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {

        return "access-denied";
    }


}
