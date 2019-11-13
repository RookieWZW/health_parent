package com.RookieWZW.service;

import com.RookieWZW.pojo.User;

/**
 * @author RookieWZW
 */
public interface UserService {
    public User findByUsername(String username);
}
