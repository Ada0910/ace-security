package com.ada.server.feign;

import com.ada.api.vo.user.UserInfo;
import com.ada.server.configuration.FeignConfiguration;
import com.ada.server.entity.JwtAuthenticationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName:IUserServiceFeign
 * @author:Ada
 * @date 2019/10/3010:18
 * @Description: 负载均衡策略
 */
@FeignClient(value = "ace-admin", configuration = FeignConfiguration.class)
public interface IUserServiceFeign {

    @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
    public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);

}
