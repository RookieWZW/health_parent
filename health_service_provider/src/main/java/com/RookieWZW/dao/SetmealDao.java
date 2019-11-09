package com.RookieWZW.dao;

import com.RookieWZW.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String,Integer> map);

    Page<Setmeal> selectByCondition(String queryString);
}
