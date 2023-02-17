package com.community.solar_embassy.controller;


import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/reply")
public class ReplyController {
    private ReplyService replyService;
    private Logger log=LoggerFactory.getLogger(this.getClass());


    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }


    @Data
    class AjaxSateHandler{
        private int state=0; //0:실패 1:성공  (statusCode : 400(badRequest),500(db 통신 오류), 405(Method 오류))
    }
    //pathVariable + (delete,patch,put,post,get)


    @PostMapping("/register.do")
    public @ResponseBody AjaxSateHandler register(Reply reply,
                                                  @SessionAttribute Users loginUser){

        AjaxSateHandler ajaxSateHandler=new AjaxSateHandler();
        int register=0;
        register=replyService.register(reply);
        ajaxSateHandler.setState(register);
        return ajaxSateHandler;
        //return "{\"state\":"+register+"}";
    }

}

