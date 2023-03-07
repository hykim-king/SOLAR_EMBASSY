package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.BoardPreferViewDto;
import com.community.solar_embassy.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;

    int insertBoard(BoardDto board) throws Exception;

    void updateViews(int boardNo) throws Exception;

    BoardDto selectBoardDetail(int boardNo) throws Exception;

    int updateBoard(BoardDto board) throws Exception;

    int deleteBoard(int boardNo) throws Exception;

    int count(BoardDto board ) throws Exception;

    List<BoardDto> selectBoardListBySize(int size);

    List<BoardDto> selectBoardListByGalaxy(int galaxyNo);

    List<BoardDto> selectBoardListByGalaxySize(int galaxyNo, int size);

    List<BoardDto> selectHot(int endNo);
    int selectEnd();

    List<BoardDto> selectListByUserId(String userId);
    BoardPreferViewDto countPreferById(int boardNo);

}



