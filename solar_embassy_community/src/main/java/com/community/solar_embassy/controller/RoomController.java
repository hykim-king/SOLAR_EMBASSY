package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Galaxy;
import com.community.solar_embassy.dto.Room;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.service.BoardImgService;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.GalaxyService;
import com.community.solar_embassy.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    GalaxyService galaxyService;
    @Autowired
    BoardService boardService;

    @Autowired
    BoardImgService boardImgService;

    @GetMapping("/roomList.do")
    public String roomList(Locale locale, Model model, @RequestParam int galaxyNo) throws Exception{
        List<Room> roomList = null;
        if (galaxyNo >=5 ){ // galaxyNo ==5 || galaxyNo == 10
            roomList = roomService.selectRoomList();
            for(Room room:roomList){
                if (room.getImgPath() == null){
                    room.setImgPath("/img/camping/어반티지 글램핑 카라반.jpeg");
                }
            }
        }
        model.addAttribute("roomList",roomList);

        List<BoardDto> list = boardService.boardListByGalaxy(galaxyNo);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        for(BoardDto boardn:list){
            boardn.setBoardImg(boardImgService.selectOne(boardn.getBoardNo()));
        }
        model.addAttribute("list", list);
        model.addAttribute("galaxyNo", galaxyNo);
        Galaxy galaxy = galaxyService.findByNo(galaxyNo);
        model.addAttribute("galaxy", galaxy);
        return "/camping";

    }
    @GetMapping("/roomWrite.do")
    public String roomWrite(Locale locale, Model model, HttpSession session, @RequestParam int galaxyNo) throws Exception {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/user/login.do";
        }
        List<Galaxy> galaxies = galaxyService.findAll();
        List<Room> rooms = roomService.findAll();
        model.addAttribute("galaxies", galaxies);
        model.addAttribute("galaxyNo", galaxyNo);
        return "/roomWrite";
    }

    @PostMapping("/roomWrite.do")
    public String roomWrite(Room room) throws Exception {
        System.out.println(room);
        int insert = roomService.insertRoom(room);
        System.out.println(insert);
        if (insert == 1) {
            return "redirect:/room/roomList.do?galaxyNo=5";
        } else {
            return "redirect:/room/roomWrite.do";
        }
    }
    @RequestMapping("/roomDetail")
    public String roomDetail(@RequestParam int roomNo, Model model) throws Exception {
        Room room = roomService.selectRoomDetail(roomNo);
        room.setRoomNo(roomNo);
        model.addAttribute("room", room);
        return "/roomDetail";
    }

    @GetMapping("/updateRoom/{RoomNo}")
    public String updateRoom(@PathVariable int roomNo, Model model, HttpSession session) throws Exception {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null){
            return "redirect:/user/login.do";
        }
        Room room = roomService.selectRoomDetail(roomNo);
        model.addAttribute("room",room);
        return "/updateRoom";
    }

    @PostMapping("/updateRoom/{roomNo}")
    public String updateRoom(Room room) throws Exception {
        roomService.updateRoom(room);
        return "redirect:/board/roomDetail?roomNo="+room.getRoomNo();
    }
    @RequestMapping(value = "/deleteRoom", method = RequestMethod.GET)
    public String deleteBoard(@RequestParam int roomNo,HttpSession session ) throws Exception {
        int delete = roomService.deleteRoom(roomNo);
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null){
            return "redirect:/user/login.do";
        }else if (delete != 1) {
            return "redirect:/room/roomDetail?roomNo=" + roomNo;
        }
        return "redirect:/room/roomList.do?roomNo=" + roomNo;
    }


}