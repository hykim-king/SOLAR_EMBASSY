package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.*;
import com.community.solar_embassy.mapper.BoardPreferMapper;
import com.community.solar_embassy.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    GalaxyService galaxyService;
    @Autowired
    ReplyService replyService;
    @Autowired
    BoardPreferService boardPreferService;
    @Autowired
    BoardPreferMapper boardPreferMapper;
    @Autowired
    UsersService usersService;

    @GetMapping("/boardList.do")
    public String boardList(Locale locale, Model model, @RequestParam int galaxyNo) throws Exception {
//        List<BoardDto> list = boardService.selectBoardList();//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        List<BoardDto> list = boardService.boardListByGalaxy(galaxyNo);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        for(BoardDto board:list){
            List<Reply> replyList = replyService.findByBoardNo(board.getBoardNo());
            board.setReplyList(replyList);
        }
        model.addAttribute("list", list);
        model.addAttribute("galaxyNo", galaxyNo);
        Galaxy galaxy = galaxyService.findByNo(galaxyNo);
        model.addAttribute("galaxy", galaxy);
        return "/boardList";
    }


    @GetMapping("/boardWrite.do")
    public String boardWrite(Locale locale, Model model, HttpSession session, @RequestParam int galaxyNo) throws Exception {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/user/login.do";
        }
        List<Galaxy> galaxies = galaxyService.findAll();
        model.addAttribute("galaxies", galaxies);
        model.addAttribute("galaxyNo", galaxyNo);
        return "/boardWrite";
    }

    @PostMapping("/boardWrite.do")
    public String boardWrite(BoardDto board) throws Exception {
        int insert = boardService.insertBoard(board);
        System.out.println(insert);
        if (insert == 1) {
            int exp = usersService.expUp(board.getUserId());
            return "redirect:/board/boardList.do?galaxyNo=" + board.getGalaxyNo();
        } else {
            return "redirect:/board/boardWrite.do";
        }
    }


    @RequestMapping("/boardDetail")
    public String boardDetail(@RequestParam int boardNo, Model model, @SessionAttribute(required = false) Users loginUser) throws Exception {
        BoardDto board = boardService.selectBoardDetail(boardNo);
        board.setUser(usersService.findById(board.getUserId()));
        board.setBoardNo(boardNo);
        board.setReplyList(replyService.findByBoardNo(boardNo));
        board.setGalaxy(galaxyService.findByNo(board.getGalaxyNo()));
        List<Reply> replyList = replyService.findFirstByBoardNo(boardNo);
        for(Reply reply:replyList){
            reply.setReReplyList(replyService.findByFkReplyNo(reply.getReplyNo()));
        }
        BoardPreferViewDto boardPreferView = new BoardPreferViewDto();
        boardPreferView.setLikes(boardPreferMapper.countByBoardNoAndPreferIsTrue(boardNo));
        boardPreferView.setDislikes(boardPreferMapper.countByBoardNoAndPreferIsFalse(boardNo));
        if (loginUser != null) {
            BoardPreferDto loginUserPrefer = boardPreferService.detail(boardNo, loginUser.getUserId());
            boardPreferView.setLoginUserPrefer(loginUserPrefer);
        }
        board.setBoardPreferView(boardPreferView);
        model.addAttribute("board", board);
        model.addAttribute("replyList", replyList);
        List<BoardDto> list = boardService.boardListByGalaxy(board.getGalaxyNo());//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        for(BoardDto boardl:list){
            boardl.setUser(usersService.findById(boardl.getUserId()));
            boardl.setReplyList(replyService.findByBoardNo(boardl.getBoardNo()));
        }
        model.addAttribute("list", list);

        return "/boardDetail2";
    }


    @GetMapping("/updateBoard/{boardNo}")
    public String updateBoard(@PathVariable int boardNo, Model model, HttpSession session) throws Exception {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/user/login.do";
        }
        BoardDto board = boardService.selectBoardDetail(boardNo);
        board.setUser(usersService.findById(board.getUserId()));
        board.setGalaxy(galaxyService.findByNo(board.getGalaxyNo()));
        model.addAttribute("board", board);

        List<Galaxy> galaxies = galaxyService.findAll();
        model.addAttribute("galaxies", galaxies);
        return "/boardUpdate";
    }

    @PostMapping("/updateBoard/{boardNo}")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board/boardDetail?boardNo=" + board.getBoardNo();
//        return "redirect:/board/updateBoard"+board.getBoardNo();
    }


    @RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
    public String deleteBoard(@RequestParam int boardNo, HttpSession session) throws Exception {
        int galaxyNo = boardService.selectBoardDetail(boardNo).getGalaxyNo();
        int delete = boardService.deleteBoard(boardNo);
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/user/login.do";
        } else if (delete != 1) {
            return "redirect:/board/boardDetail?boardNo=" + boardNo;
        }
        return "redirect:/board/boardList.do?galaxyNo=" + galaxyNo;
    }
}
