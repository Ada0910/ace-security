package com.ada.api.vo.authority;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ada
 * @ClassName :PermissionInfo
 * @date 2019/10/3 11:23
 * @Description:
 */
@Getter
@Setter
public class PermissionInfo {
    private String code;
    private String type;
    private String uri;
    private String method;
    private String name;
    private String menu;
}
