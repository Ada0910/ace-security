package com.ada.admin.mapper;

import com.ada.admin.entity.Menu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Ada
 * @ClassName :MenuMapper
 * @date 2019/10/5 17:28
 * @Description:
 */
public interface MenuMapper extends Mapper<Menu> {

    public List<Menu> selectMenuByAuthorityId(@Param("authorityId") String authorityId, @Param("authorityType") String authorityType);

    /**
     * 根据用户和组的权限关系查找用户可访问菜单
     */
    public List<Menu> selectAuthorityMenuByUserId(@Param("userId") int userId);

    /**
     * 根据用户和组的权限关系查找用户可访问的系统
     */
    public List<Menu> selectAuthoritySystemByUserId(@Param("userId") int userId);
}
