package com.ada.admin.controller;

import com.ada.admin.biz.MenuBiz;
import com.ada.admin.biz.UserBiz;
import com.ada.admin.entity.Menu;
import com.ada.admin.entity.User;
import com.ada.admin.service.PermissionService;
import com.ada.admin.vo.FrontUser;
import com.ada.admin.vo.MenuTree;
import com.ada.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ada
 * @ClassName :UserController
 * @date 2019/10/5 10:09
 * @Description:
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz, User> {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private MenuBiz menuBiz;

    /**
     * ResponseEntity能够返回状态码和http响应头
     */
    @RequestMapping(value = "/front/info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(String token) throws Exception {
        FrontUser userInfo = permissionService.getUserInfo(token);
        if (userInfo == null) {
            return ResponseEntity.status(401).body(false);
        } else {
            return ResponseEntity.ok(userInfo);
        }
    }

    @RequestMapping(value = "/front/menus", method = RequestMethod.GET)
    public @ResponseBody
    List<MenuTree> getMenuByUserName(String token) throws Exception {
        return permissionService.getMenusByUseName(token);
    }

    @RequestMapping(value = "/front/menu/all", method = RequestMethod.GET)
    public @ResponseBody
    List<Menu> getAllMenus() throws Exception {
        return menuBiz.selectListAll();
    }

}
