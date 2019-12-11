package com.ada.admin.mapper;

import com.ada.admin.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Ada
 * @ClassName :UserMapper
 * @date 2019/10/5 17:13
 * @Description:
 */
public interface UserMapper extends Mapper<User> {
    public List<User> selectMemberByGroupId(@Param("groupId") int groupId);

    public List<User> selectLeaderByGroupId(@Param("groupId") int groupId);

    public User selectUser(String username);
}
