package com.ada.admin.biz;

import com.ada.admin.entity.GroupType;
import com.ada.admin.mapper.GroupTypeMapper;
import com.ada.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName:GroupTypeBiz
 * @author: Ada
 * @date 2019/10/22 17:33
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper, GroupType> {
}
