package com.xiao.ex.utils;

/**
 * Created by xiao on 2017/6/18.
 * 分页类
 */
public class PageObj {
    /**
     * 数据总数key
     */
    private String count;
    /**
     * 总共有多少页
     */
    private String pages;
    /**
     * 一页多少条数
     */
    private String pageSize;
    /**
     * 当前页数
     */
    private String page;
    /**
     * 显示key
     */
    private Object list ;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }
}
