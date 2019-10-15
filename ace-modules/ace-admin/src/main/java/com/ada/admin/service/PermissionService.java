package com.ada.admin.service;

import com.ada.admin.biz.ElementBiz;
import com.ada.admin.biz.MenuBiz;
import com.ada.admin.biz.UserBiz;
import com.ada.admin.constant.AdminCommonConstant;
import com.ada.admin.entity.Element;
import com.ada.admin.entity.Menu;
import com.ada.admin.entity.User;
import com.ada.admin.vo.FrontUser;
import com.ada.admin.vo.MenuTree;
import com.ada.api.vo.authority.PermissionInfo;
import com.ada.api.vo.user.UserInfo;
import com.ada.client.util.UserAuthUtil;
import com.ada.common.constant.CommonConstant;
import com.ada.common.util.TreeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private ElementBiz elementBiz;

    @Autowired
    private UserAuthUtil userAuthUtil;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /**
     * 通过用户名来获取用户
     */
    public UserInfo getUserByUserName(String userName) {
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUserName(userName);
        BeanUtils.copyProperties(user, info);
        info.setId(user.getId().toString());
        return info;
    }

    /**
     * 校验用户名和密码
     */
    public UserInfo validate(String userName, String password) {
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUserName(userName);
        if (encoder.matches(password, user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString());
        }
        return info;
    }

    public List<PermissionInfo> getAllPermission() {
        List<Menu> menus = menuBiz.selectListAll();
        List<PermissionInfo> result = new ArrayList<>();
        PermissionInfo info = null;
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAllElementPermissions();
        element2permission(result, elements);
        return result;
    }

    public void menu2permission(List<Menu> menus, List<PermissionInfo> result) {
        PermissionInfo info;
        for (Menu menu : menus) {
            if (StringUtils.isBlank(menu.getHref())) {
                menu.setHref("/" + menu.getCode());
            }
            info = new PermissionInfo();
            info.setCode(menu.getCode());
            info.setType(AdminCommonConstant.RESOURCE_TYPE_MENU);
            info.setName(AdminCommonConstant.RESOURCE_ACTION_VISIT);
            String uri = menu.getHref();
            if (!uri.startsWith("/")) {
                uri = "/" + uri;
            }
            info.setUri(uri);
            info.setMethod(AdminCommonConstant.RESOURCE_REQUEST_METHOD_GET);
            result.add(info);
            info.setMenu(menu.getTitle());
        }
    }

    private void element2permission(List<PermissionInfo> result, List<Element> elements) {
        PermissionInfo info;
        for (Element element : elements) {
            info = new PermissionInfo();
            info.setCode(element.getCode());
            info.setType(element.getType());
            info.setUri(element.getUri());
            info.setMethod(element.getMethod());
            info.setName(element.getName());
            info.setMenu(element.getMenuId());
            result.add(info);

        }
    }

    public List<PermissionInfo> getPermissionByUsername(String username) {
        User user = userBiz.getUserByUserName(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        PermissionInfo info = null;
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAuthorityElementByUserId(user.getId() + "");
        element2permission(result, elements);
        return result;
    }

    private List<MenuTree> getMenuTree(List<Menu> menus, int root) {
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        for (Menu menu : menus) {
            node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees, root);
    }

    /**
     * 获取用户信息
     */
    public FrontUser getUserInfo(String token) throws Exception {
        //获取用户名
        String userName = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if (userName == null) {
            return null;
        }
        UserInfo user = this.getUserByUserName(userName);
        FrontUser frontUser = new FrontUser();
        BeanUtils.copyProperties(user, frontUser);
        List<PermissionInfo> permissionInfos = this.getPermissionByUsername(userName);
        Stream<PermissionInfo> menus = permissionInfos.parallelStream().filter((permission) -> {
            return permission.getType().equals(CommonConstant.RESOURCE_TYPE_MENU);
        });
        frontUser.setMenus(menus.collect(Collectors.toList()));
        Stream<PermissionInfo> elements = permissionInfos.parallelStream().filter((permission) -> {
            return !permission.getType().equals(CommonConstant.RESOURCE_TYPE_MENU);
        });
        frontUser.setElements(elements.collect(Collectors.toList()));
        return frontUser;
    }

    public List<MenuTree> getMenusByUseName(String token) throws Exception {
        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if (username == null) {
            return null;
        }
        User user = userBiz.getUserByUserName(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        return getMenuTree(menus, AdminCommonConstant.ROOT);
    }

}
