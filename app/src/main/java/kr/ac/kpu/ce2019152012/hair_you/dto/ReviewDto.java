package kr.ac.kpu.ce2019152012.hair_you.dto;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class ReviewDto {
    private Long idx;
    private String content;
    private LocalDateTime writtenAt;
    private ShopDto shopId; // FK 미용실
    private CustomerDto cId; // FK 고객

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ReviewDto(String content, String writtenAt, ShopDto shopId, CustomerDto cId) {
        this.content = content;
        this.writtenAt = LocalDateTime.now();
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

    public LocalDateTime getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(LocalDateTime writtenAt) {
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
