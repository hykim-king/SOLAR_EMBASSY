package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.AjaxStateHandler;
import com.community.solar_embassy.dto.BoardPreferDto;
import com.community.solar_embassy.dto.BoardPreferViewDto;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.BoardPreferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/board/prefer")
public class BoardPreferController {

    @Autowired
    BoardPreferService boardPreferService;

    @GetMapping("view.do")
    public String view(int boardNo, Model model, @SessionAttribute(required = false) Users loginUser){
        String loginUserId = (loginUser != null) ? loginUser.getUserId() : null;
        BoardPreferViewDto boardPreferView = boardPreferService.detailBoardPreferView(boardNo, loginUserId);
        model.addAttribute("prefer", boardPreferView);
        System.out.println(boardPreferView);
        //prefer의 loginUserPrefer도 null이 나오고 있네요
        return "/boardPrefer";
    }

    @RequestMapping(path = "/handler.do", method = {RequestMethod.PUT})
    public @ResponseBody AjaxStateHandler handler(@RequestParam int boardNo,
                                                  boolean preferBtn,
                                                  @SessionAttribute Users loginUser) {
        AjaxStateHandler ajaxStateHandler = new AjaxStateHandler();
        BoardPreferDto userLoginPrefer = boardPreferService.detail(boardNo, loginUser.getUserId());
        int handler = 0;
        if (userLoginPrefer == null) {
            userLoginPrefer = new BoardPreferDto();
            userLoginPrefer.setBoardNo(boardNo);
            userLoginPrefer.setUserId(loginUser.getUserId());
            userLoginPrefer.setPrefer(preferBtn);
            handler = boardPreferService.register(userLoginPrefer);
        } else {
            if (userLoginPrefer.isPrefer() == preferBtn) {
                handler = boardPreferService.remove(userLoginPrefer.getBoardPreferNo());
            } else {
                userLoginPrefer.setPrefer(preferBtn);
                handler = boardPreferService.modify(userLoginPrefer);
            }
        }
        ajaxStateHandler.setState(handler);
        return ajaxStateHandler;
    }

}
