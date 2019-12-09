package com.ada.api.vo.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ada
 * @ClassName :UserInfo
 * @date 2019/10/3 11:27
 * @Description:
 */
@Getter
@Setter
public class UserInfo implements Serializable {
    public String id;
    public String username;
    public String password;
    public String name;
    private String description;
    private Date updTime;
}
