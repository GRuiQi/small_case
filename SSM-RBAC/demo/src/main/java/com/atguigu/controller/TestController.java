package com.atguigu.controller;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    /*
    * 测试spring和mybatis是否集成
    * */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Object queryAll(){
        List<User> users = userService.queryAll();
        return users;
    }

    /*
    * 测试springmvc是否集成
    * */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /*
    * map才能返回json对象的形式
    * */
    @RequestMapping("/json")
    @ResponseBody
    public Object json(){
        Map map  = new HashMap();
        map.put("username","password");
        return map;
    }


}
