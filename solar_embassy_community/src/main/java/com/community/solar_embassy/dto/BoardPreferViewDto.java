package com.community.solar_embassy.dto;

import lombok.Data;

@Data
public class BoardPreferViewDto {
    private int likes;
    private int dislikes;
    private BoardPreferDto loginUserPrefer; // 로그인 유저가 열람한 게시글에 대한 좋아요 싫어요 상태

}
