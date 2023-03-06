package com.community.solar_embassy.service;

import com.community.solar_embassy.dto.BoardPreferDto;
import com.community.solar_embassy.dto.BoardPreferViewDto;

public interface BoardPreferService {
    BoardPreferViewDto detailBoardPreferView(int boardNo, String loginUserId);
    int register(BoardPreferDto boardPrefer);
    int modify(BoardPreferDto boardPrefer);
    int remove(int boardPreferNo);
    BoardPreferDto detail(int boardNo,String loginUserId);
}
