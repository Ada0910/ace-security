package com.ada.admin.mapper;

import com.ada.admin.entity.ResourceAuthority;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName:ResourceAuthorityMapper
 * @author:Ada
 * @date 2019/10/2211:28
 * @Description:
 */
public interface ResourceAuthorityMapper extends Mapper<ResourceAuthority> {
    public void deleteByAuthorityIdAndResourceType(@Param("authorityId") String authorityId, @Param("resourceType") String resourceType);
}
