package com.ada.admin.mapper;

import com.ada.admin.entity.Group;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName:GroupMapper
 * @author:Ada
 * @date 2019/10/2211:16
 * @Description:
 */
public interface GroupMapper extends Mapper<Group> {
    public void deleteGroupMembersById(@Param("groupId") int groupId);

    public void deleteGroupLeadersById(@Param("groupId") int groupId);

    public void insertGroupMembersById(@Param("groupId") int groupId, @Param("userId") int userId);

    public void insertGroupLeadersById(@Param("groupId") int groupId, @Param("userId") int userId);

}
