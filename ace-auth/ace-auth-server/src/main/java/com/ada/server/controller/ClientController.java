package com.ada.server.controller;

import com.ada.common.response.ObjectRestResponse;
import com.ada.server.configuration.KeyConfiguration;
import com.ada.server.service.AuthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:ClientController
 * @author: Ada
 * @date 2019/10/31 15:10
 * @Description:
 */
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private AuthClientService authClientService;

    @Autowired
    private KeyConfiguration keyConfiguration;

    public ObjectRestResponse getAccessToken(String clientId, String secret)throws Exception {
        return new ObjectRestResponse<String>().data(authClientService.apply(clientId,secret));
    }
    @RequestMapping(value = "/myClient")
    public ObjectRestResponse getAllowedClient(String serviceId, String secret) {
        return new ObjectRestResponse<List<String>>().data(authClientService.getAllowedClient(serviceId, secret));
    }

    @RequestMapping(value = "/servicePubKey",method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getServicePublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret) throws Exception {
        authClientService.validate(clientId, secret);
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getServicePubKey());
    }

    @RequestMapping(value = "/userPubKey",method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret) throws Exception {
        authClientService.validate(clientId, secret);
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getUserPubKey());
    }

}
