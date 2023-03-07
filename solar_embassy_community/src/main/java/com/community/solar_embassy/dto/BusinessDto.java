package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class BusinessDto implements Serializable {

    private int buNo;
    private String buId;
    private String buPasswords;
    private String buName;
    private String email;
    private String phone;

    private Date regDate;

    private Date updateTime;
    private int state;
    private int auth;

    private static final long serialVersionUID = 1L;

    public BusinessDto(String buId,String buPasswords, String buName, String email, String phone,Date regDate, int state, int auth ){
        this.buId = buId;
        this.buPasswords = buPasswords;
        this.buName = buName;
        this.email = email;
        this.phone = phone;
        this.regDate = regDate;
        this.state = state;
        this.auth = auth;
    }

    public int getBuNo() {
        return buNo;
    }

    public void setBuNo(int buNo) {
        this.buNo = buNo;
    }

    public String getBuId() {
        return buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    public String getBuPasswords() {
        return buPasswords;
    }

    public void setBuPasswords(String buPasswords) {
        this.buPasswords = buPasswords;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "BusinessDto{" +
                "buNo=" + buNo +
                ", buId='" + buId + '\'' +
                ", buPasswords='" + buPasswords + '\'' +
                ", buName='" + buName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", regDate=" + regDate +
                ", updateTime=" + updateTime +
                ", state=" + state +
                ", auth=" + auth ;
    }
}