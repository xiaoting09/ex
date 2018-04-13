package com.xiao.ex.service.impl.vo;

/**
 * 钉钉消息
 *
 * @author 肖亭
 * @since 2018年04月13 10:52
 **/
public class DingDingMsgVo {

    private String msgtype;


    private LinkMsg link;

    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public LinkMsg getLink() {
        return link;
    }

    public void setLink(LinkMsg link) {
        this.link = link;
    }


}
