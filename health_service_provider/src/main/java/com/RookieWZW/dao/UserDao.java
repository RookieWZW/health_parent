package com.RookieWZW.dao;

import com.RookieWZW.pojo.User;

public interface UserDao {
    public User findByUsername(String username);
}
