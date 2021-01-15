package com.atguigu.bean;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Permission {
    private Integer id;
    private String name;
    private String url;
    private Integer pid;
    private boolean open = true;
    private boolean checked = false;
    private String icon;
    private List<Permission> children = new ArrayList<Permission>();
}
