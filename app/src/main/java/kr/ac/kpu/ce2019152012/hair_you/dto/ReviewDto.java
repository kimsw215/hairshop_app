package kr.ac.kpu.ce2019152012.hair_you.dto;

public class ReviewDto {
    private Long idx;
    private String content;
    private String writtenAt;
    private String shopId; // FK 미용실
    private String cId; // FK 고객

    public ReviewDto(String content, String writtenAt, String shopId, String cId) {
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

    public String getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(String writtenAt) {
        this.writtenAt = writtenAt;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }
}
