package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.ReplyService;
import com.community.solar_embassy.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UsersService usersService;
    private BoardService boardService;
    private ReplyService replyService;

    public UserController(UsersService usersService, BoardService boardService, ReplyService replyService) {
        this.usersService = usersService;
        this.boardService = boardService;
        this.replyService = replyService;
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
            @RequestParam(name = "userId") String userId,
            @RequestParam String passwords,
            HttpSession session,
            @SessionAttribute(required = false) String redirectUri) {
        Users user = usersService.login(userId, passwords);
        session.setAttribute("loginUser", user);
        if (user == null) {
            session.setAttribute("msg", "아이디나 비밀번호를 확인하세요!");
            return "redirect:/user/login.do";
        } else {
            if (redirectUri == null || redirectUri.equals("http://localhost:8888/user/signup_normal.do")) {
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

    @PostMapping("withdrawal.do")
    public String withdrawal(HttpSession session) {
        int withdrawal = usersService.withdrawal((Users) (session.getAttribute("loginUser")));
        if (withdrawal == 1) {
            return "redirect:/";
        } else {
            return "redirect:/user/withdrawal.do";
        }
    }

    @GetMapping("signup.do")
    public String signup() {
        return "/user/signup/signup";
    }

    @GetMapping("signup_normal.do")
    public String signup_normal(
    ) {
        return "/user/signup/signup_normal";
    }

    @PostMapping("signup_normal.do")
    public String signup_normal(Users users,
                                @RequestParam(name = "passwords_check") String passwords_check) {
        int signup_normal = 0;
        if (users.getPasswords().equals(passwords_check) && !users.getUserId().equals("")) {
            try {
                signup_normal = usersService.signup_normal(users);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (signup_normal > 0) {
            return "redirect:/user/login.do";
        } else {
            return "redirect:/user/signup_normal.do";
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
    public String my_page(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("loginUser");
        List<BoardDto> myBoardList = boardService.BoardListByUserId(user.getUserId());
        model.addAttribute("myBoards", myBoardList);
        List<Reply> replyList = replyService.findByUserId(user.getUserId());
        model.addAttribute("myReplyList",replyList);
        return "user/my_page";
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
    public String find_id_result_phone() {
        return "/user/find/find_id_result_phone";
    }

    @GetMapping("find_id_result_email.do")
    public String find_id_result_email() {
        return "/user/find/find_id_result_email";
    }

    @GetMapping("find_pw.do")
    public String find_pw() {
        return "/user/find/find_pw";
    }

    @GetMapping("find_pw_security.do")
    public String find_pw_security() {
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

    @PostMapping("pw_check.do")
    public String pw_check(@RequestParam String passwords, HttpSession session, @SessionAttribute String redirectUri) {
        Users user = (Users) session.getAttribute("loginUser");
        if (user.getPasswords().equals(passwords)) {
            return "redirect:/user/user_info_modify.do";
        } else {
            return "redirect:/user/pw_check.do";
        }
    }

    @GetMapping("user_info_modify.do")
    public String user_info_modify(HttpSession session) {
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/user/login.do";
        } else {
            return "user/user_info_modify";
        }
    }

    @PostMapping("user_info_modify.do")
    public String user_info_modify(@SessionAttribute Users loginUser, Users user, HttpSession session) {
        System.out.println(user.getPasswords());
        System.out.println(user.getPasswords_C());
        if (user.getPasswords() != null && user.getPasswords().equals(user.getPasswords_C())) {
            int modify = usersService.modify(user);
            if (modify == 1) {
                Users loginUpdate = usersService.login(user.getUserId(), user.getPasswords());
                session.setAttribute("loginUser", loginUpdate);
                return "redirect:/user/my_page.do";
            }
        }
        return "redirect:/user/user_info_modify.do";
    }

    @PostMapping("nickCheck")
    public String nickCheck(String nickname, HttpSession session) {
        int check = usersService.findNick(nickname);
        return "redirect:/user/user_info_modify.do?nickCheck=" + check;
    }

}
