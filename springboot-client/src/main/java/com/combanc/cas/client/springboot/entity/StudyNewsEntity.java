package com.combanc.cas.client.springboot.entity;

public class StudyNewsEntity extends BaseDto<StudyNewsEntity> {
    private String id;

    private String newsTitle;//标题

    private String briefIntroduction;//简介

    private String backPic;//背景图

    private String displayLocation;//展示位置

    private Integer newsWeight;//动态权重 0-9999 ，顺序排列，再加加时间

    private String createTime;//创建时间

    private Integer readingVolume;

    private String userId;

    private String newsContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getBackPic() {
        return backPic;
    }

    public void setBackPic(String backPic) {
        this.backPic = backPic;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public Integer getNewsWeight() {
        return newsWeight;
    }

    public void setNewsWeight(Integer newsWeight) {
        this.newsWeight = newsWeight;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(Integer readingVolume) {
        this.readingVolume = readingVolume;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}