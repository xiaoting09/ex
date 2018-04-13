package com.xiao.ex.service.impl;

import com.google.gson.Gson;
import com.xiao.ex.common.CacheUtil;
import com.xiao.ex.entity.ExClient;
import com.xiao.ex.entity.ExClientData;
import com.xiao.ex.service.MsgService;
import com.xiao.ex.service.impl.vo.DingDingMsgVo;
import com.xiao.ex.service.impl.vo.LinkMsg;
import com.xiao.ex.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * 钉钉消息发送
 *
 * @author 肖亭
 * @since 2018年04月13 10:16
 **/
@Service(value = "dingDingMsgService")
public class DingDingMsgServiceImpl implements MsgService {
    @Value("${server.url:url}")
    private String url;

    @Override
    public void sendMsg(ExClient client, ExClientData data) {
        Boolean cache = true;
        try {
            cache = CacheUtil.getCache(data.getExClass());
        } catch (ExecutionException e) {
            e.printStackTrace();
            return;
        }
        if (cache){
            return;
        }
        LinkMsg msg = new LinkMsg();
        msg.setMessageUrl(url + "/data/showData?id=" + data.getId());
        msg.setTitle(client.getIp() + "#" + data.getExClass());
        msg.setText(data.getMsg());
        DingDingMsgVo msgVo = new DingDingMsgVo();
        msgVo.setLink(msg);
        msgVo.setMsgtype("link");
        Gson gson = new Gson();
        HttpClientUtil.postJson(client.getDingdingToken(), gson.toJson(msgVo));
    }
}
