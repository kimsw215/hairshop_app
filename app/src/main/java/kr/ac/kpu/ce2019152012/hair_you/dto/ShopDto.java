package kr.ac.kpu.ce2019152012.hair_you.dto;

public class ShopDto {
    private Long id;
    private String info;
    private String shopName;
    private String address;
    private double latitude;
    private double longitude;

    public String getAllInfo() {
        return "ShopDto{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public ShopDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public ShopDto(String info, String shopName, String address, double latitude, double longitude) {
        this.info = info;
        this.shopName = shopName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
