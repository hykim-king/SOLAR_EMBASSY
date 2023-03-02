package com.community.solar_embassy.dto;

import lombok.Data;

@Data
public class BoardPreferDto {
    private int boardPreferNo;
    private int boardNo;
    private boolean prefer;
    private String userId;
}
