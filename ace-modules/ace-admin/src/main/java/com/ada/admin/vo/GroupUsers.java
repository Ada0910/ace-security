package com.ada.admin.vo;

import com.ada.admin.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName:GroupUsers
 * @author: Ada
 * @date 2019/09/30 10:39
 * @Description:
 */
@Getter
@Setter
public class GroupUsers {
    List<User> members;
    List<User> leaders;

    public GroupUsers() {
    }

    public GroupUsers(List<User> members, List<User> leaders) {
        this.members = members;
        this.leaders = leaders;
    }

}
