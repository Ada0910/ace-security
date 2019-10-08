package com.ada.admin.biz;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.ada.admin.entity.Element;
import com.ada.admin.mapper.ElementMapper;
import com.ada.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName:ElementBiz
 * @author: Ada
 * @date 2019/10/08 13:55
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementBiz extends BaseBiz<ElementMapper, Element> {

    @Cache(key = "permission:ele:u{1}")
    public List<Element> getAuthorityElementByUserId(String userId) {
        return mapper.selectAuthorityElementByUserId(userId);
    }

    public List<Element> getAuthorityElementByUserId(String userId, String menuId) {
        return mapper.selectAuthorityMenuElementByUserId(userId, menuId);
    }

    @Cache(key = "permission:ele")
    public List<Element> getAllElementPermissions() {
        return mapper.selectAllElementPermissions();
    }

    @Override
    @CacheClear(keys = {"permission:ele", "permission"})
    public void insertSelective(Element element) {
        super.insertSelective(element);
    }

    @Override
    @CacheClear(keys = {"permission:ele", "permission"})
    public void updateSelectiveById(Element entity) {
        super.updateSelectiveById(entity);
    }


}
