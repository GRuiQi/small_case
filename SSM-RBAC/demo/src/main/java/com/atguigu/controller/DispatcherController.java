package com.atguigu.controller;

import com.atguigu.bean.AJAXResult;
import com.atguigu.bean.Permission;
import com.atguigu.bean.User;
import com.atguigu.service.PermissionService;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //session.removeAttribute("loginUser");
        //所有的session失效
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }





    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session) {

        AJAXResult result = new AJAXResult();

        User dbUser = userService.query4Login(user);
        if ( dbUser != null ) {
            session.setAttribute("loginUser", dbUser);

            // 获取用户权限信息
            List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
            Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
            Permission root = null;
            Set<String> uriSet = new HashSet<String>();
            for ( Permission permission : permissions ) {
                permissionMap.put(permission.getId(), permission);
                if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
                    uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
                }
            }
            session.setAttribute("authUriSet", uriSet);
            for ( Permission permission : permissions ) {
                Permission child = permission;
                if ( child.getPid() == 0 ) {
                    root = permission;
                } else {
                    Permission parent = permissionMap.get(child.getPid());
                    parent.getChildren().add(child);
                }
            }
            session.setAttribute("rootPermission", root);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }


    /**
     * 执行登陆
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model){

        // 1) 获取表单数据
        // 1-1) HttpServletRequest
        // 1-2) 在方法参数列表中增加表单对应的参数，名称相同
        // eg. doLogin(String loginacc, String pwassword)
        // 1-3) 就是将表单数据封装为实体类对象

        // 2) 查询用户信息  完善User类
        User dbUser = userService.query4Login(user);

        // 3) 判断用户信息是否存在
        if ( dbUser != null ) {
            // 登陆成功，跳转到主页面  默认是转发进行页面跳转
            return "main";
        } else {
            // 登陆失败，跳转回到登陆页面，提示错误信息
            String errorMsg = "登陆账号或密码不正确，请重新输入";
            model.addAttribute("errorMsg", errorMsg);
            //重定向的方式进行页面跳转
            return "redirect:login";
        }
    }
}

