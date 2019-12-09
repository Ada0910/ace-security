package com.ada.server.service.impl;

import com.ada.common.exception.auth.ClientInvalidException;
import com.ada.common.util.UUIDUtils;
import com.ada.server.entity.Client;
import com.ada.server.entity.ClientInfo;
import com.ada.server.mapper.ClientMapper;
import com.ada.server.service.AuthClientService;
import com.ada.server.util.client.ClientTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:AuthClientServiceImpl
 * @author: Ada
 * @date 2019/10/31 17:12
 * @Description:
 */
@Service
public class AuthClientServiceImpl implements AuthClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private DiscoveryClient discovery;

    private ApplicationContext context;

    @Autowired
    public AuthClientServiceImpl(ApplicationContext context) {
        this.context = context;
    }

    /**
     * 生成token
     */
    @Override
    public String apply(String clientId, String secret) throws Exception {
        Client client = getClient(clientId, secret);
        return clientTokenUtil.generateToken(new ClientInfo(client.getCode(), client.getName(), client.getId().toString()));

    }

    /**
     * 获取client
     */
    private Client getClient(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return client;
    }

    /**
     * 获取被授权的client
     */
    @Override
    public List<String> getAllowedClient(String serviceId, String secret) {
        Client info = this.getClient(serviceId, secret);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if (clients == null) {
            new ArrayList<String>();
        }
        return clients;
    }

    @Override
    public List<String> getAllowedClient(String serviceId) {
        Client info = getClient(serviceId);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if (clients == null) {
            new ArrayList<String>();
        }
        return clients;
    }

    /**
     * 获取client
     */
    private Client getClient(String clientId) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        return client;
    }

    /**
     * 自动注册
     */
    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void registryClient() {
        // 自动注册节点
        discovery.getServices().forEach((name) -> {
            Client client = new Client();
            client.setName(name);
            client.setCode(name);
            Client dbClient = clientMapper.selectOne(client);
            if (dbClient == null) {
                client.setSecret(UUIDUtils.generateShortUuid());
                clientMapper.insert(client);
            }
        });
    }

    /**
     * 校验
     */
    @Override
    public void validate(String clientId, String secret) throws Exception {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
    }
}
