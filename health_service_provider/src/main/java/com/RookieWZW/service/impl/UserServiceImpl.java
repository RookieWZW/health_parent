package com.RookieWZW.service.impl;

import com.RookieWZW.dao.PermissionDao;
import com.RookieWZW.dao.RoleDao;
import com.RookieWZW.dao.UserDao;
import com.RookieWZW.pojo.Permission;
import com.RookieWZW.pojo.Role;
import com.RookieWZW.pojo.User;
import com.RookieWZW.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @program: health_parent
 * @description: //
 * @author: RookieWZW
 * @create: 2019-11-12 17:01
 */
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null){
            return null;
        }

        Integer userId = user.getId();
        Set<Role> roles = roleDao.findByUserId(userId);
        if (roles!=null && roles.size()>0){
            for (Role role :
                    roles) {
                Integer roleId = role.getId();
                Set<Permission> permissions = permissionDao.findByRoleId(roleId);
                if (permissions!=null && permissions.size()>0){
                    role.setPermissions(permissions);
                }
            }
            user.setRoles(roles);
        }
        return user;
    }
}