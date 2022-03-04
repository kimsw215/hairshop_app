package kr.ac.kpu.ce2019152012.hair_you.dto;

public class UserDto {
    private String userName;
    private String userEmail;
    private String userPasswd;

    public UserDto() {

    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
