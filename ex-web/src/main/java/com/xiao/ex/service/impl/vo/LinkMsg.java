package com.xiao.ex.service.impl.vo;

/**
 * 消息实体
 *
 * @author 肖亭
 * @since 2018年04月13 10:57
 **/
public class LinkMsg {
    /**
     * 消息内容。如果太长只会部分展示
     */
    private String text;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 图片URL
     */
    private String picUrl;
    /**
     * 点击消息跳转的URL
     */
    private String messageUrl;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }
}
