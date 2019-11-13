package com.RookieWZW.dao;

import com.RookieWZW.pojo.Permission;

import java.util.Set;

/**
 * @program: health_parent
 * @description:
 * @author: RookieWZW
 * @create: 2019-11-12 17:06
 */
public interface PermissionDao {
    public Set<Permission> findByRoleId(int roleId);
}