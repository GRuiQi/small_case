package com.atguigu.dao;

import com.atguigu.bean.Permission;
import com.atguigu.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from t_permission where pid = #{pid}")
    List<Permission> queryChildPermissions(Integer pid);

    @Select("select * from t_permission")
    List<Permission> queryAll();

    @Select("select * from t_permission where id = #{id}")
    Permission queryById(Integer id);

    void insertPermission(Permission permission);

    void updatePermission(Permission permission);

    void deletePermission(Permission permission);

    @Select("select permissionid from t_role_permission where roleid = #{roleid}")
    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionsByUser(User dbUser);
}
