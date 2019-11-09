package com.RookieWZW.dao;

import com.RookieWZW.pojo.CheckGroup;
import com.RookieWZW.pojo.CheckItem;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {

    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map map);

    Page<CheckGroup> selectByCondition(String queryString);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void deleteAssocication(Integer id);

    void edit(CheckGroup checkGroup);
}
