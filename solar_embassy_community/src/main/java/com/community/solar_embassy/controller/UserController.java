package com.community.solar_embassy.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("login.do")
    public void login() {
    }

    @GetMapping("withdrawl.do")
    public void withdrawal() {
    }

    @GetMapping("signup.do")
    public void signup() {
    }

    @GetMapping("signup_normal.do")
    public void signup_normal() {
    }

    @GetMapping("signup_business.do")
    public void signup_business() {
    }

    @GetMapping("rocket.do")
    public void rocket() {
    }

    @GetMapping("next.do")
    public void next() {
    }

    @GetMapping("next_2.do")
    public void next_2() {
    }

    @GetMapping("next_3.do")
    public void next_3() {
    }

    @GetMapping("search.do")
    public void search(){
    }

}
