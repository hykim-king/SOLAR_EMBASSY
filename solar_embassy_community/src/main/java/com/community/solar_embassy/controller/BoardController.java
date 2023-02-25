package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Galaxy;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.GalaxyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    GalaxyService galaxyService;

    @GetMapping("/boardList.do")
    public String boardList(Locale locale, Model model, @RequestParam int galaxyNo) throws Exception {
//        List<BoardDto> list = boardService.selectBoardList();//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        List<BoardDto> list = boardService.boardListByGalaxy(galaxyNo);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        model.addAttribute("list", list);
        model.addAttribute("galaxyNo", galaxyNo);
        Galaxy galaxy = galaxyService.findByNo(galaxyNo);
        model.addAttribute("galaxy",galaxy);
        return "/boardList";
    }


    @GetMapping("/boardWrite.do")
    public String boardWrite(Locale locale, Model model, HttpSession session, @RequestParam int galaxyNo) throws Exception {
      Users loginUser = (Users) session.getAttribute("loginUser");
        if ( loginUser == null) {
            return "redirect:/user/login.do";
       }
        List<Galaxy> galaxies = galaxyService.findAll();
        model.addAttribute("galaxies",galaxies);
        model.addAttribute("galaxyNo",galaxyNo);
        return "/boardWrite";
    }

//    @PostMapping("/board/boardWrite")
//    public String boardWrite(BoardDto board) throws Exception {
//        boardService.insertBoard(board);
//        return "redirect:/board/boardList.do";
//    }
    @PostMapping("/boardWrite.do")
    public String boardWrite(BoardDto board) throws Exception {
        int insert = boardService.insertBoard(board);
        System.out.println(insert);
        if (insert == 1) {
            return "redirect:/board/boardList.do?galaxyNo="+board.getGalaxyNo();
        }
        else{
            return "redirect:/board/boardWrite.do";
        }
    }

    @RequestMapping("/boardDetail")
    public String boardDetail(@RequestParam int boardNo,  Model model) throws Exception {
        BoardDto board = boardService.selectBoardDetail(boardNo);
        board.setBoardNo(boardNo);
        model.addAttribute("board",board);
        return "/boardDetail";
    }
//     return "redirect:  (설정한 링크로 가는 것 ) / html로 가면 redirect 제외해야 함

    //    @RequestMapping("/openBoardDetail")
//    public ModelAndView openBoardDetail(@RequestParam int board_no) throws Exception{
//        ModelAndView mv = new ModelAndView("/boardDetail");
//        BoardDto board = boardService.selectBoardDetail(board_no);
//        mv.addObject("board",board);
//        return mv;
//    }
    @RequestMapping("/updateBoard")  // 수정요청
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);         //게시글 수정
        return "redirect:/board/boardList.do";  //수정완료 후 게시판 목록으로
    }


    @RequestMapping (value = "deleteBoard", method = RequestMethod.POST)
    public String deleteBoard(@RequestParam int boardNo) throws Exception {
        int galaxyNo = boardService.selectBoardDetail(boardNo).getGalaxyNo();
        int delete = boardService.deleteBoard(boardNo);
        if (delete !=1) {
            return "redirect:/board/boardDetail?boardNo="+boardNo;
        }
        return "redirect:/board/boardList.do?galaxyNo="+galaxyNo;
    }



//    @RequestMapping("/deleteBoard")  //삭제요청
//    public String deleteBoard(BoardDto board) throws Exception {
//        boardService.deleteBoard(board.getBoardNo());      //게시글 삭제
//        return "redirect:/board/boardList";  //삭제완료 후 게시판 목록으로
//    }

}
