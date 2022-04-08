package kr.ac.kpu.ce2019152012.hair_you.dto;

public class DesignerDto {
    //json key 값과 dto
    private Long identification; // 기본키
    private String name;
    private String id;
    private String password;
    private String phone;
    private String gender;
    private ShopDto shopId; // FK 미용실

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
        return phone;
    }

    public void setPhoneNum(String phoneNum) {
        this.phone = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ShopDto getShop_name() {
        return shopId;
    }

    public void setShop_name(ShopDto shop_name) {
        this.shopId = shop_name;
    }




    public DesignerDto(String name, String id, String password, String phoneNum, String gender, ShopDto shop) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phone = phoneNum;
        this.gender = gender;
        this.shopId = shop;
    }
}
