package com.ada.gate.feign;

import com.ada.api.vo.log.LogInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName:ILogServiceFeign
 * @author: Ada
 * @date 2019/11/14 11:26
 * @Description: @FeignClient注解中标识出准备调用的是当前服务场中的哪个服务(作用到哪个微服务上)
 * 即相当于访问saveLog就可以调用ace-admin模块的对应的/api/log/save的服务
 */

@FeignClient("ace-admin")
public interface ILogServiceFeign {

    @RequestMapping(value = "/api/log/save", method = RequestMethod.POST)
    void saveLog(LogInfo info);
}
