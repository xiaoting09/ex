package com.xiao.ex.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 说明:  分页插件
 *
 * @author xiaoting
 *         Created by 2017-03-24 17:18
 **/
public class PageUtil {
    /**
     * 一页多少条数据
     */
    public static final int PAGE_SIZE = 10;

    /**
     * 传入当前需要查询的第几页不传默认差寻第一页
     *
     * @param pageNum 当前页
     */
    public static void startPage(Integer pageNum) {
        if (Objects.isNull(pageNum)) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, PAGE_SIZE);
    }

    /**
     * 传入当前需要查询的第几页不传默认差寻第一页
     *
     * @param pageNum 当前页
     * @param size    一页多少数据
     */
    public static void startPage(Integer pageNum, Integer size) {
        if (Objects.isNull(pageNum)) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, size);
    }

    /**
     * 查询第1页数据
     */
    public static void startPage() {
        startPage(null);
    }

    /**
     * 传入list获取分页参数
     *
     * @param list 数据集合
     * @return
     */
    public static PageObj getObj(List<?> list) {
        PageObj pageObj = new PageObj();
        PageInfo pageInfo = new PageInfo(list);
        if (CollectionUtils.isEmpty(list)) {
            pageObj.setCount("0");
            pageObj.setPage("0");
            pageObj.setPages("0");
            pageObj.setPageSize("0");
        } else {
            pageObj.setCount(pageInfo.getTotal() + "");
            pageObj.setPage(pageInfo.getPageNum() + "");
            pageObj.setPages(pageInfo.getPages() + "");
            pageObj.setPageSize(pageInfo.getPageSize() + "");
        }
        pageObj.setList(list);
        return pageObj;
    }

    /**
     * 传入list获取分页参数
     * * @return
     */
    public static PageObj getObj() {
        return getObj(new ArrayList<>());
    }


}
