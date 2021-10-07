package com.combanc.cas.client.springboot.entity;

public class CenterIntroduceEntity extends BaseDto<CenterIntroduceEntity> {
    private String id;

    private String introduceTitle;

    private String introduceBrief;

    private String backPic;

    private String introduceType;

    private Integer introduceWeight;

    private String createTime;

    private String introduceContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduceTitle() {
        return introduceTitle;
    }

    public void setIntroduceTitle(String introduceTitle) {
        this.introduceTitle = introduceTitle;
    }

    public String getIntroduceBrief() {
        return introduceBrief;
    }

    public void setIntroduceBrief(String introduceBrief) {
        this.introduceBrief = introduceBrief;
    }

    public String getBackPic() {
        return backPic;
    }

    public void setBackPic(String backPic) {
        this.backPic = backPic;
    }

    public String getIntroduceType() {
        return introduceType;
    }

    public void setIntroduceType(String introduceType) {
        this.introduceType = introduceType;
    }

    public Integer getIntroduceWeight() {
        return introduceWeight;
    }

    public void setIntroduceWeight(Integer introduceWeight) {
        this.introduceWeight = introduceWeight;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIntroduceContent() {
        return introduceContent;
    }

    public void setIntroduceContent(String introduceContent) {
        this.introduceContent = introduceContent;
    }
}