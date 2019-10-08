package com.ada.admin.mapper;

import com.ada.admin.entity.Element;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName:ElementMapper
 * @author:Ada
 * @date 2019/10/0814:00
 * @Description:
 */
public interface ElementMapper extends Mapper<Element> {
    public List<Element> selectAuthorityElementByUserId(@Param("userId") String userId);

    public List<Element> selectAuthorityMenuElementByUserId(@Param("userId") String userId, @Param("menuId") String menuId);

    public List<Element> selectAuthorityElementByClientId(@Param("clientId") String clientId);

    public List<Element> selectAllElementPermissions();
}
