package com.atguigu.service;

import com.atguigu.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryAll();

    User query4Login(User user);

    List<User> pageQueryData(Map<String,Object> map);

    int pageQueryCount(Map<String,Object> map);

    void insertUser(User user);

    void updateUser(User user);

    User queryById(Integer id);

    void deleteUsers(Map<String,Object> map);

    void deleteUserById(Integer id);

    List<Integer> queryRoleidsByUserid(Integer id);

    void insertUserRoles(Map<String,Object> map);

    void deleteUserRoles(Map<String,Object> map);
}
