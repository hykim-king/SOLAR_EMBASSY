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
    public String signup() {
        return "/user/signup/signup";
    }

    @GetMapping("signup_normal.do")
    public String signup_normal() {
        return "/user/signup/signup_normal";
    }
    @PostMapping("signup_normal.do")
    public String signup_normal(Users users){
        int signup_normal = 0;
        try{
            signup_normal = usersService.signup_normal(users);
        } catch (Exception e){
            e.printStackTrace();
        }
        if (signup_normal > 0){
            return "redirect:/user/rocket.do";
        } else {
            return "redirect:/user/signup/signup_normal.do";
        }

    }
    @GetMapping("signup_business.do")
    public String signup_business() {
        return "/user/signup/signup_business";
    }

    @GetMapping("rocket.do")
    public String rocket() {
        return "/user/signup/rocket";
    }

    @GetMapping("next.do")
    public String next() {
        return "/user/signup/next";
    }

    @GetMapping("next_2.do")
    public String next_2() {
        return "/user/signup/next_2";
    }

    @GetMapping("next_3.do")
    public String next_3() {
        return "/user/signup/next_3";
    }

    @GetMapping("my_page.do")
    public void my_page(HttpSession session) {
    }

    @GetMapping("user_black.do")
    public void user_black(HttpSession session) {
    }

    @GetMapping("search.do")
    public void search(HttpSession session) {
    }

    @GetMapping("find_id.do")
    public String find_id() {
        return "/user/find/find_id";
    }
    @GetMapping("find_id_result_phone.do")
    public String find_id_result_phone(){
        return "/user/find/find_id_result_phone";
    }
    @GetMapping("find_id_result_email.do")
    public String find_id_result_email(){
        return "/user/find/find_id_result_email";
    }
    @GetMapping("find_pw.do")
    public String find_pw(){
        return "/user/find/find_pw";
    }

    @GetMapping("find_pw_security.do")
    public String find_pw_security(){
        return "/user/find/find_pw_security";
    }
    @GetMapping("pw_check.do")
    public void pw_check(HttpServletRequest req, HttpSession session,
                                   @SessionAttribute(required = false) String redirectUri) {
        String referer = req.getHeader("referer");
        if (redirectUri == null && !(referer.equals("http://localhost:8888/") || referer.equals("http://localhost:8888/user/login.do"))) {
            session.setAttribute("redirectUri", referer);
        }
    }

    @GetMapping("user_info_modify.do")
    public void user_info_modify(){}

}
