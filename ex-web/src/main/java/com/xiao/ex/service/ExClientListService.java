package com.xiao.ex.service;


import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.entity.ExClientList;
import com.xiao.ex.utils.PageObj;

import java.util.List;

/**
 * Created by xiaoting on 2017/9/13.
 */
public interface ExClientListService {
    /**
     * 查询管理的
     *
     * @param clientList
     * @return
     */
    List<ExClientList> findExClinetList(ExClientList clientList);

    /**
     * 存储错误信息
     *
     * @param vo
     */
    void addExClinet(ExceptionVo vo);

    /**
     * 查询分页结果
     *
     * @param page
     * @return
     */
    PageObj getPageList(Integer page);

    void addExClinetList(ExClientList exClientList);

    /**
     * 根据ID删除
     * @param id
     */
    void updateById(Integer id);
}
