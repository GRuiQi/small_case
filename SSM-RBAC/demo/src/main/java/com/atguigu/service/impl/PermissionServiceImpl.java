package com.atguigu.service.impl;

import com.atguigu.bean.Permission;
import com.atguigu.bean.User;
import com.atguigu.dao.PermissionDao;
import com.atguigu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> queryChildPermissions(Integer id) {
        return permissionDao.queryChildPermissions(id);
    }

    @Override
    public void deletePermission(Permission permission) {
        permissionDao.deletePermission(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDao.updatePermission(permission);
    }

    @Override
    public void insertPermission(Permission permission) {
        permissionDao.insertPermission(permission);
    }

    @Override
    public Permission queryById(Integer id) {
        return permissionDao.queryById(id);
    }

    @Override
    public List<Permission> queryAll() {
        return permissionDao.queryAll();
    }

    @Override
    public List<Integer> queryPermissionidsByRoleid(Integer roleid) {
        return    permissionDao.queryPermissionidsByRoleid(roleid);
    }

    @Override
    public List<Permission> queryPermissionsByUser(User dbUser) {
        return  permissionDao.queryPermissionsByUser(dbUser);
    }
}
