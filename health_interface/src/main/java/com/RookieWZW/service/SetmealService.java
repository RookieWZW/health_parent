package com.RookieWZW.service;

import com.RookieWZW.entity.PageResult;
import com.RookieWZW.pojo.Setmeal;

public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
}
