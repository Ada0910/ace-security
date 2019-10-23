package com.ada.admin.biz;

import com.ada.admin.entity.GateLog;
import com.ada.admin.mapper.GateLogMapper;
import com.ada.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName:GateLogBiz
 * @author: Ada
 * @date 2019/10/23 15:10
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GateLogBiz extends BaseBiz<GateLogMapper, GateLog> {
    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
