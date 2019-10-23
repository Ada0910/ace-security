package com.ada.client.Feign;

import com.ada.common.response.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName:ServiceAuthFeign
 * @author: Ada
 * @date 2019/10/23 16:38
 * @Description:
 */
@FeignClient(value = "${auth.serviceId}", configuration = {})
public interface ServiceAuthFeign {
    @RequestMapping(value = "/client/myClient")
    public ObjectRestResponse<List<String>> getAllowedClient(@RequestParam("serviceId") String serviceId, @RequestParam("secret") String secret);

    @RequestMapping(value = "/client/token", method = RequestMethod.POST)
    public ObjectRestResponse getAccessToken(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

    @RequestMapping(value = "/client/servicePubKey", method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getServicePublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

    @RequestMapping(value = "/client/userPubKey", method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

}
