package com.doge.blog.utils;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Meddkim on 2017/9/24.
 */
@Data
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long totalCount;  //总记录数
    private int currentPage;  //当前页数
    private int pageSize;     //每页记录数
    private int currentPageSize; //当前页有多少条数据 <= pageSize;
    private int totalPage;  //总页数

    private List items;


    public PageBean(List<T> list){
        if(list instanceof Page){
            Page<T> page = (Page<T>) list;
            this.totalCount = page.getTotal();
            this.currentPage = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.currentPageSize = page.size();
            this.totalPage = page.getPages();
//            this.items = page;
            this.items = Lists.newArrayList();
        }
    }

    /**
     * 加入数据
     * @param
     */
    public void add(Object obj){
        this.items.add(obj);
    }

    public void addAll(List list){
        this.items = list;
    }

}
