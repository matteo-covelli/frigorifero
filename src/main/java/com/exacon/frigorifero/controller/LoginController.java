package com.exacon.frigorifero.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    private HttpServletRequest logoutHandler;

    @GetMapping("/")
    public String showlog() {
        return "login-page";
    }

    // il nome del getMapping corrisponde a quello specificato nel DemoSecurityConfig
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "login-page";
    }

    // add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String accessDenied() {

        return "access-denied";
    }


}
