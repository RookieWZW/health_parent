package com.RookieWZW.dao;

import com.RookieWZW.pojo.Role;

import java.util.Set;

public interface RoleDao {
    public Set<Role> findByUserId(int id);
}
