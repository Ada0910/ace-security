package com.ada.gate.feign;

import com.ada.api.vo.authority.PermissionInfo;
import com.ada.gate.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName:IUserServiceFeign
 * @author:Ada
 * @date 2019/11/1416:14
 * @Description:
 */
@FeignClient(value = "ace-admin", fallback = UserServiceFallback.class)
public interface IUserServiceFeign {
    @RequestMapping(value = "/api/user/un/{userName}/permissions", method = RequestMethod.GET)
    public List<PermissionInfo> getPermissionByUserName(@PathVariable("userName") String userName);

    @RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
    List<PermissionInfo> getAllPermissionInfo();
}
