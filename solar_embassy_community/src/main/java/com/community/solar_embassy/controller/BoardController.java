package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.ReplyService;
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
    ReplyService replyService;

    @GetMapping("/boardList.do")
    public String boardList(Locale locale, Model model) throws Exception {
        List<BoardDto> list = boardService.selectBoardList();//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        model.addAttribute("list", list);
        return "/boardList";
    }

    @GetMapping("/boardWrite.do")
    public String boardWrite(Locale locale, Model model) throws Exception {
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
            return "redirect:/board/boardList.do";
        }
        else{
            return "redirect:/board/boardWrite.do";
        }
    }


    @GetMapping("/{boardNo}/boardDetail.do") /*@RequestParam int boardNo, Model model*/
    public String boardDetail(Locale locale, Model model, @PathVariable int boardNo) throws Exception {
        List<BoardDto> list = boardService.selectBoardList();//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        BoardDto board=boardService.selectBoardDetail(boardNo);
        List<Reply> replyList = replyService.findByBoardNo(boardNo);
        for(Reply reply:replyList){
           reply.setRereplyList(replyService.findByFkReplyNo(reply.getReplyNo()));
        }
        model.addAttribute("list", list);
        model.addAttribute("board",board);
        model.addAttribute("replyList",replyList);


//        BoardDto board = boardService.selectBoardDetail(boardNo);
//        board.setBoardNo(boardNo);
//        model.addAttribute("board",board);
        return "boardDetail";
    }

//     return "redirect:  (설정한 링크로 가는 것 ) / html로 가면 redirect 제외해야 함

    //    @RequestMapping("/openBoardDetail")
//    public ModelAndView openBoardDetail(@RequestParam int board_no) throws Exception{
//        ModelAndView mv = new ModelAndView("/boardDetail");
//        BoardDto board = boardService.selectBoardDetail(board_no);
//        mv.addObject("board",board);
//        return mv;
//    }

    /*
    * @GetMapping("/{boardNo}/modify.do")
    public String modify(@PathVariable int boardNo,
                         @SessionAttribute UserDto loginUser,
                         Model model){
        BoardDto board=boardService.detail(boardNo);
        model.addAttribute("board",board);
        return  "/board/modify";
    }*/
    @GetMapping("/{boardNo}/boardUpdate.do")
    public String boardUpdate(Locale locale, Model model,HttpSession session, @PathVariable int boardNo) throws Exception {
        if (session.getAttribute("loginUser")== null) {
            return "redirect:/user/login.do";
        }
        BoardDto board=boardService.selectBoardDetail(boardNo);
        model.addAttribute("board",board);


        return "/boardUpdate";
    }


    @PostMapping("/{boardNo}/boardUpdate.do")  // 수정요청
    public String boardUpdate(Model model, @PathVariable int boardNo) throws Exception {
        BoardDto board=boardService.selectBoardDetail(boardNo);

        model.addAttribute("board",board);
        boardService.updateBoard(board);         //게시글 수정

        return "redirect:/board/{boardNo}/boardDetail";  //수정완료 후 수정된 디테일로
    }

    /*
    @GetMapping("/{boardNo}/modify.do")
    public String modify(@PathVariable int boardNo,
                         @SessionAttribute UserDto loginUser,
                         Model model){
        BoardDto board=boardService.detail(boardNo);
        model.addAttribute("board",board);
        return  "/board/modify";
    }*/

    @RequestMapping (value = "deleteBoard", method = RequestMethod.POST)
    public String deleteBoard(@RequestParam int boardNo) throws Exception {
        boardService.deleteBoard(boardNo);
        return "redirect:/board/boardList.do";
    }



//    @RequestMapping("/deleteBoard")  //삭제요청
//    public String deleteBoard(BoardDto board) throws Exception {
//        boardService.deleteBoard(board.getBoardNo());      //게시글 삭제
//        return "redirect:/board/boardList";  //삭제완료 후 게시판 목록으로
//    }

}
