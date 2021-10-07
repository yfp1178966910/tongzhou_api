package com.combanc.cas.client.springboot.entity;

public class WebMessageEntity extends BaseDto<WebMessageEntity> {


    private String id;


    private String messageTitle;//活动主题


    private String department;//部门


    private String departmentPart;//处室


    private Integer readingVolume;//阅读量


    private String createTime;//创建时间


    private String isFloat;//是否浮动窗口推送  0 否  1 是


    private String messageContent;//发信内容


    private String filesUrl;//附件 json


    private String userId;//用户ID
    private String readUser;//读过消息的用户
    private String deleteUser;//删除消息的用户
    private Integer wasRead;//已读状态  0 否  1 是

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentPart() {
        return departmentPart;
    }

    public void setDepartmentPart(String departmentPart) {
        this.departmentPart = departmentPart;
    }

    public Integer getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(Integer readingVolume) {
        this.readingVolume = readingVolume;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsFloat() {
        return isFloat;
    }

    public void setIsFloat(String isFloat) {
        this.isFloat = isFloat;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReadUser() {
        return readUser;
    }

    public void setReadUser(String readUser) {
        this.readUser = readUser;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }

    public Integer getWasRead() {
        return wasRead;
    }

    public void setWasRead(Integer wasRead) {
        this.wasRead = wasRead;
    }
}