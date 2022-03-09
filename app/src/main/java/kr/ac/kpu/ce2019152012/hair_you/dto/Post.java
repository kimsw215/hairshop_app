package kr.ac.kpu.ce2019152012.hair_you.dto;

import com.google.gson.annotations.SerializedName;

/*
    JSON 데이터를 받아오는 Class
    @SerializedName 으로 Json객체와 해당 변수를 매칭
    POST 매핑으로 받아올 경우 굳이 어노테이션 안 붙이고 JSON객체의 변수명과 일치하게 선언해도 됨

 */
public class Post {
    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
