package com.exacon.frigorifero.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    private HttpServletRequest logoutHandler;

    @GetMapping("/")
    public String showlog() {
        return "fancy-login";
    }

    // il nome del getMapping corrisponde a quello specificato nel DemoSecurityConfig
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        // return "plain-login";
        return "fancy-login";
    }

    // add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String accessDenied() {

        return "access-denied";
    }


}
