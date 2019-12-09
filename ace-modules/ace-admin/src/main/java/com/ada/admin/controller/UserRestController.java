package com.ada.admin.controller;

import com.ace.cache.annotation.Cache;
import com.ada.admin.service.PermissionService;
import com.ada.api.vo.authority.PermissionInfo;
import com.ada.api.vo.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Ada
 * @ClassName :UserRestController
 * @date 2019/10/26 23:24
 * @Description:
 */
@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private PermissionService permissionService;

    @Cache(key = "permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public @ResponseBody
    List<PermissionInfo> getAllPermission() {
        return permissionService.getAllPermission();
    }


    @Cache(key = "permission:u{1}")
    @RequestMapping(value = "/user/un/{userName}/permissions", method = RequestMethod.GET)
    public @ResponseBody
    List<PermissionInfo> getPermissionByUserName(@PathVariable("username") String userName) {
        return permissionService.getPermissionByUserName(userName);
    }

    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo validate(@RequestBody Map<String, String> body) {
        return permissionService.validate(body.get("userName"), body.get("password"));
    }

}
