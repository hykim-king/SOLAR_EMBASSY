package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardPreferDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardPreferMapper {
    int countByBoardNoAndPreferIsTrue(int boardNo);

    int countByBoardNoAndPreferIsFalse(int boardNo);


    int insert(BoardPreferDto boardPrefer);

    int update(BoardPreferDto boardPrefer);

    int delete(int boardPreferNo);


    BoardPreferDto findByBoardNoAndUserId(int boardNo, String userId);

    List<BoardPreferDto> findByUserId(String userId);
}
