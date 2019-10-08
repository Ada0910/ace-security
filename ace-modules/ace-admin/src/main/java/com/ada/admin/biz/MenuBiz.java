package com.ada.admin.biz;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.ada.admin.constant.AdminCommonConstant;
import com.ada.admin.entity.Menu;
import com.ada.admin.mapper.MenuMapper;
import com.ada.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName:MenuBiz
 * @author: Ada
 * @date 2019/10/08 10:37
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuBiz extends BaseBiz<MenuMapper, Menu> {

    @Override
    @Cache(key = "permisssion:menu")
    public List<Menu> selectListAll() {
        return super.selectListAll();
    }


    @Override
    @CacheClear(keys = {"permission:menu", "permission"})
    public void insertSelective(Menu menu) {
        //root用户
        if (AdminCommonConstant.ROOT == menu.getParentId()) {
            menu.setPath("/" + menu.getCode());
        } else {
            //非root用户，路径=父节点的路径+"/"+自己节点路径
            Menu parent = this.selectById(menu.getParentId());
            menu.setPath(parent.getPath() + "/" + menu.getCode());
        }
        super.insertSelective(menu);
    }

    @Override
    @CacheClear(keys = {"permission:menu", "permission"})
    public void updateById(Menu menu) {
        if (AdminCommonConstant.ROOT == menu.getParentId()) {
            menu.setPath("/" + menu.getCode());
        } else {
            Menu parent = this.selectById(menu.getParentId());
            menu.setPath(parent.getPath() + "/" + parent.getCode());
        }
        super.updateById(menu);
    }

    @Override
    @CacheClear(keys = {"permission:menu", "permission"})
    public void updateSelectiveById(Menu menu) {
        super.updateSelectiveById(menu);
    }

    /**
     * 根据用户获取可以访问的菜单
     */
    @Cache(key = "permission:menu:u{1}")
    public List<Menu> getUserAuthorityMenuByUserId(int id) {
        return mapper.selectAuthorityMenuByUserId(id);
    }

    /**
     * 根据用户获取可以访问的系统
     */
    public List<Menu> getUserAuthoritySystemByUserId(int id) {
        return mapper.selectAuthoritySystemByUserId(id);
    }

}
