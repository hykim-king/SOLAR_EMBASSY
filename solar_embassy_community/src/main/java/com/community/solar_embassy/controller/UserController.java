package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("login.do")
    public void login(HttpServletRequest req,
                      HttpSession session,
                      @SessionAttribute(required = false) String redirectUri) {
        String referer = req.getHeader("referer");
        if (redirectUri == null && !(referer.equals("http://localhost:8888/") || referer.equals("http://localhost:8888/user/login.do"))) {
            session.setAttribute("redirectUri", referer);
        }
    }

    @PostMapping("/login.do")
    public String login(
            @RequestParam(name = "user_id") String userId,
            String pw,
            HttpSession session,
            @SessionAttribute(required = false) String redirectUri) {
        Users user = usersService.login(userId, pw);
        session.setAttribute("loginUser", user);
        if (user == null) {
            session.setAttribute("msg", "아이디나 비밀번호를 확인하세요!");
            return "redirect:/user/login.do";
        } else {
            if (redirectUri == null) {
                return "redirect:/";
            }
            session.removeAttribute("redirectUri");
            return "redirect:" + redirectUri;
        }
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/";
    }

    @GetMapping("withdrawal.do")
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

    @GetMapping("my_page.do")
    public void my_page(HttpSession session) {
    }

    @GetMapping("user_black.do")
    public void user_black(HttpSession session) {
    }
    @GetMapping("search.do")
    public void search(HttpSession session){}


    @GetMapping("find_id.do")
    public void find_id(){
    }
    @GetMapping("find_id_result.do")
    public void find_id_result(){
    }
    @GetMapping("find_pw.do")
    public void find_pw(){
    }

    @GetMapping("find_pw_security.do")
    public void find_pw_security(){
    }

}
