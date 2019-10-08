package com.ada.admin.service;

import com.ada.admin.biz.MenuBiz;
import com.ada.admin.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:PermissionService
 * @author: Ada
 * @date 2019/10/08 10:30
 * @Description:
 */
@Service
public class PermissionService {

    @Autowired
    private UserBiz userBiz;

    @Autowired
    private MenuBiz menuBiz;
}
