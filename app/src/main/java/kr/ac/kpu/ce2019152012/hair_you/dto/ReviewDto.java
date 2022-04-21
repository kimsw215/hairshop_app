package kr.ac.kpu.ce2019152012.hair_you.dto;

import java.time.LocalDate;

public class ReviewDto {
    private Long idx;
    private String content;
    private LocalDate writtenAt;
    private ShopDto shopId; // FK 미용실
    private CustomerDto cId; // FK 고객

    public ReviewDto(String content, LocalDate writtenAt, ShopDto shopId, CustomerDto cId) {
        this.content = content;
        this.writtenAt = writtenAt;
        this.shopId = shopId;
        this.cId = cId;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(LocalDate writtenAt) {
        this.writtenAt = writtenAt;
    }

    public ShopDto getShopId() {
        return shopId;
    }

    public void setShopId(ShopDto shopId) {
        this.shopId = shopId;
    }

    public CustomerDto getcId() {
        return cId;
    }

    public void setcId(CustomerDto cId) {
        this.cId = cId;
    }
}
