package com.xiao.ex.service;

import com.xiao.ex.entity.ExClient;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.web.vo.ClinetRespVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户端接口
 * Created by xiaoting on 2017/9/11.
 */
public interface ClientService {
    /**
     * 根据IP获取客户信息
     * 如果获取不到信息则创建
     *
     * @param ip ip
     * @return
     */
    ExClient findClientByIp(String ip);

    /**
     * 创建异常客户端信息
     *
     * @param client 创建信息
     */

    ExClient insertExClient(ExClient client);

    /**
     * 查询数据
     *
     * @param client cli
     * @return
     */
    List<ExClient> getExClients(ExClient client);

    /**
     * 更新客户端
     *
     * @param exClient
     */
    void updateExClient(ExClient exClient);

    /**
     * 查询客户端列表
     *
     * @return
     */
    List<ClinetRespVo> getClinetList();

    /**
     * 分页查询
     * @param page 分页
     * @return
     */
    PageObj getClinetPageList(Integer page);
}
