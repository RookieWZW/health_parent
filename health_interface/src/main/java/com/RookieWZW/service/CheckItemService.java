package com.RookieWZW.service;

import com.RookieWZW.entity.PageResult;
import com.RookieWZW.entity.QueryPageBean;
import com.RookieWZW.pojo.CheckItem;

import java.util.List;

//服务接口
public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public void deleteById(Integer id);
    public void edit(CheckItem checkItem);
    public CheckItem findById(Integer id);
    public List<CheckItem> findAll();
}
