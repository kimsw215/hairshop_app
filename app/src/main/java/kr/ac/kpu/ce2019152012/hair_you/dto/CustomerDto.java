package kr.ac.kpu.ce2019152012.hair_you.dto;

import kotlin.BuilderInference;

public class CustomerDto {
    private Long identification; // 기본키
    private String name;
    private String id;
    private String password;
    private String phoneNum;
    private String gender;


    public CustomerDto( String name, String id, String password, String phoneNum, String gender) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phoneNum = phoneNum;
        this.gender = gender;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
