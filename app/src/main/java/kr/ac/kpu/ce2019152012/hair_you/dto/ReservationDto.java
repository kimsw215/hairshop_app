package kr.ac.kpu.ce2019152012.hair_you.dto;

public class ReservationDto {
    private Long idx;
    private String curCondition;
    private String detail;
    private String reservedAt;
    private String cId; // FK 고객
    private String shopId; // FK 미용실

    public ReservationDto(String curCondition, String detail, String reservedAt, String cId, String shopId) {
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

    public String getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(String reservedAt) {
        this.reservedAt = reservedAt;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
