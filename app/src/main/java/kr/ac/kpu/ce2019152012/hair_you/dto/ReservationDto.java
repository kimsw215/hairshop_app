package kr.ac.kpu.ce2019152012.hair_you.dto;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class ReservationDto {
    private Long idx;
    private String curCondition;
    private String detail;
    private String reservedAt;
    private String createdAt;
    private CustomerDto cId; // FK 고객
    private ShopDto shopId; // FK 미용실

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ReservationDto(String curCondition, String detail, String reservedAt, CustomerDto cId, ShopDto shopId) {
        this.curCondition = curCondition;
        this.detail = detail;
        this.reservedAt = reservedAt;
        this.createdAt = LocalDateTime.now().toString();
        this.cId = cId;
        this.shopId = shopId;
    }


    public String getInfo() {
        return "ReservationDto{" +
                "idx=" + idx +
                ", curCondition='" + curCondition + '\'' +
                ", detail='" + detail + '\'' +
                ", reservedAt='" + reservedAt + '\'' +
                '}';
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getCurCondition() {
        return curCondition;
    }

    public void setCurCondition(String curCondition) {
        this.curCondition = curCondition;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(String reservedAt) {
        this.reservedAt = reservedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CustomerDto getcId() {
        return cId;
    }

    public void setcId(CustomerDto cId) {
        this.cId = cId;
    }

    public ShopDto getShopId() {
        return shopId;
    }

    public void setShopId(ShopDto shopId) {
        this.shopId = shopId;
    }
}
