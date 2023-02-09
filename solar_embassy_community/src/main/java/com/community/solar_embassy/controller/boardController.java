package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.service.BoardService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/board")
public class boardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/boardList.do")
    public String  boardList(Locale locale, Model model) throws Exception {
        List<BoardDto> list = boardService.selectBoardList();//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        model.addAttribute("list",list);
        return "/boardList";
    }
    @GetMapping("/openBoardWrite")
    public void boardWrite() {}

    @RequestMapping("/insertBoard")
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);
        return "redirect:/board/boardList";
    }
    @RequestMapping("/openBoardDetail")
    public ModelAndView openBoardDetail(@RequestParam int board_no) throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardDetail");
        BoardDto board = boardService.selectBoardDetail(board_no);
        mv.addObject("board",board);
        return mv;
    }
    @RequestMapping("/updateBoard")  // 수정요청
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);         //게시글 수정
        return "redirect:/board/openBoardList";  //수정완료 후 게시판 목록으로
    }


    @RequestMapping("/deleteBoard")  //삭제요청
    public String deleteBoard(BoardDto board) throws Exception {
        boardService.deleteBoard(board.getBoardNo());      //게시글 삭제
        return "redirect:/board/boardList";  //삭제완료 후 게시판 목록으로
    }

}
