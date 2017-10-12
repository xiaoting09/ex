package com.xiao.ex.service;


import com.xiao.ex.entity.ExList;
import com.xiao.ex.utils.PageObj;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaoting on 2017/9/11.
 */
public interface ExListService {
    /**
     * 查询异常信息
     *
     * @param exList 异常信息
     * @return
     */
    List<ExList> findList(ExList exList);

    /**
     * 创建异常现象
     *
     * @param exName 异常名称
     * @return
     */
    ExList addEx(String exName);

    /**
     * 根据异常名称查询异常信息如果没有则新增
     *
     * @param exName 异常名称
     * @return
     */
    ExList findExOrAdd(String exName);

    /**
     * 获取异常列表
     *
     * @return
     */
    List<String> getExList();

    /**
     * 查询异常列表
     *
     * @param page 分页
     * @return
     */
    PageObj getExListPage(Integer page);

    /**
     * 修改状态
     *
     * @param exList
     */

    void updateEx(ExList exList);

    /**
     * 新增
     *
     * @param exList
     */
    void addEx(ExList exList);
}
