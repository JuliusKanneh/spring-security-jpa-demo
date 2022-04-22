package com.wisdom.springsecurityjpademo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/reports")
    public String reports(){
        return "reports";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "sign-in";
    }

    @GetMapping("/success-logout")
    public String logout(){
        return "redirect:/login";
    }
}
