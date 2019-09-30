package com.ada.server.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName:FrontUser
 * @author: Ada
 * @date 2019/09/2717:26
 * @Description:
 */
@Getter
@Setter
public class FrontUser {
    public String id;
    public String userName;
    public String name;
    private String description;
    private String image;
    //private List<PermissionInfo> menus;
    //private List<PermissionInfo> elements;
}
