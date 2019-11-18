package com.ada.sidecar.client.client;

import com.ada.sidecar.client.entity.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName:PythonFeignClient
 * @author: Ada
 * @date 2019/11/18 15:32
 * @Description:
 */
@FeignClient(name = "ace-sidecar-server")
public interface PythonFeignClient {

    //parse param like /message?id=12
    @RequestMapping("/message/{id}")
    List<Message> getMsg(@RequestParam("id") Long id);

    //parse url like /test
    @RequestMapping("/test")
    String getTest();
}