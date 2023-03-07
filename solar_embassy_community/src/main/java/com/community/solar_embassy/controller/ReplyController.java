package com.community.solar_embassy.controller;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private BoardService boardService;
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Data
    class AjaxSateHandler {
        private int state = 0; //0:실패 1:성공  (statusCode : 400(badRequest),500(db 통신 오류), 405(Method 오류))
    }
    //pathVariable + (delete,patch,put,post,get)

    @GetMapping("/{boardNo}/list.do")
    public String list(@PathVariable int boardNo,
                       HttpServletRequest req,
                       Model model) {
        List<Reply> replyList = replyService.findFirstByBoardNo(boardNo);
        for (Reply reply : replyList) {
            reply.setReReplyList(replyService.findByFkReplyNo(reply.getReplyNo()));
        }
        model.addAttribute("replyList", replyList);
        BoardDto board = null;
        try {
            board = boardService.selectBoardDetail(replyList.get(0).getBoardNo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("board", board);
        return "/reply/list";
    }

    @PostMapping("/register.do")
    public @ResponseBody AjaxSateHandler register(Reply reply,
                                                  @SessionAttribute Users loginUser) {
        AjaxSateHandler ajaxSateHandler = new AjaxSateHandler();
        int register = 0;
        register = replyService.register(reply);
        ajaxSateHandler.setState(register);
        return ajaxSateHandler;
        //return "{\"state\":"+register+"}";
    }

    @GetMapping("/modify.do")
    public String modify(@RequestParam int replyNo,
                         @SessionAttribute Users loginUser,
                         Model model) {
        Reply reply = replyService.findOne(replyNo);
        model.addAttribute("reply", reply);
        return "/reply/modify";
    }

    @PutMapping("/modify.do")
    public @ResponseBody AjaxSateHandler modify(
            Reply reply,
            @SessionAttribute Users loginUser
//            ,@RequestParam(required = false, name = "imgFile") MultipartFile imgFile
    ) {
        AjaxSateHandler ajaxSateHandler = new AjaxSateHandler();
        int modify = replyService.modifyOne(reply);
        ajaxSateHandler.setState(modify);
        return ajaxSateHandler;
    }

    @DeleteMapping("/delete.do")
    public @ResponseBody AjaxSateHandler delete(Reply replyNo,
                                                @SessionAttribute Users loginUser) {
        AjaxSateHandler ajaxSateHandler = new AjaxSateHandler();
        int delete = 0;
        delete = replyService.delete(replyNo);
        ajaxSateHandler.setState(delete);
        return ajaxSateHandler;
    }


}

