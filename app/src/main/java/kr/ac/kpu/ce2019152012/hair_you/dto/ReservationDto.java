package kr.ac.kpu.ce2019152012.hair_you.dto;

import java.time.LocalDateTime;

public class ReservationDto {
    private Long idx;
    private String curCondition;
    private String detail;
    private LocalDateTime reservedAt;
    private LocalDateTime createdAt;
    private CustomerDto cId; // FK 고객
    private ShopDto  shopId; // FK 미용실

    public ReservationDto(String curCondition, String detail, LocalDateTime reservedAt, CustomerDto cId, ShopDto shopId) {
        this.curCondition = curCondition;
        this.detail = detail;
        this.reservedAt = reservedAt;
        this.cId = cId;
        this.shopId = shopId;
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

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
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
