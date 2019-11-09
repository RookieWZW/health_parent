package com.RookieWZW.service;

import com.RookieWZW.entity.PageResult;
import com.RookieWZW.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    public void add(CheckGroup checkGroup,Integer[] checkitemIds);
    public PageResult pageQuery(Integer currentPage,Integer pageSize,String queryString);

    CheckGroup findById(Integer id);
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    void edit(CheckGroup checkGroup, Integer[] checkitemIds);
}
