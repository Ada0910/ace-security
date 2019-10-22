package com.ada.admin.biz;

import com.ada.admin.entity.ResourceAuthority;
import com.ada.admin.mapper.ResourceAuthorityMapper;
import com.ada.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper, ResourceAuthority> {
}
