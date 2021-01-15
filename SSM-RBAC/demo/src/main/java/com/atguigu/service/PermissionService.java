package com.atguigu.service;

import com.atguigu.bean.Permission;
import com.atguigu.bean.User;


import java.util.List;


public interface PermissionService {
    List<Permission> queryChildPermissions(Integer id);

    List<Permission> queryAll();

    void deletePermission(Permission permission);

    void updatePermission(Permission permission);

    void insertPermission(Permission permission);

    Permission queryById(Integer id);

    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionsByUser(User dbUser);
}
