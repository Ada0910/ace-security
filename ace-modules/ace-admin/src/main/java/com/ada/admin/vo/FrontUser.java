package com.ada.admin.vo;

import com.ada.api.vo.authority.PermissionInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Ada
 * @ClassName :FrontUser
 * @date 2019/10/3 11:15
 * @Description:
 */
@Getter
@Setter
public class FrontUser {
    public String id;
    public String username;
    public String name;
    private String description;
    private String image;
    private List<PermissionInfo> menus;
    private List<PermissionInfo> elements;
}
