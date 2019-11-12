package com.RookieWZW.service;

import com.RookieWZW.entity.Result;

import java.util.Map;

public interface OrderService {
    public Result Order(Map map) throws Exception;

    Map findById(Integer id);
}
