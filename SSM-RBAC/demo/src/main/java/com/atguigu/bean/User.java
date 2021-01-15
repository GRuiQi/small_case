package com.atguigu.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String loginacct;
    private String userpswd;
    private String email;
    private String createtime;
}
