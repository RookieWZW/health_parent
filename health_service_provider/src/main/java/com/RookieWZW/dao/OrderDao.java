package com.RookieWZW.dao;

import com.RookieWZW.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    public void add(Order order);

    public List<Order> findByCondition(Order order);

    Map findById4Detail(Integer id);
}
