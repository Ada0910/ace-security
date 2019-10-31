package com.ada.server.mapper;

import com.ada.server.entity.Client;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName:ClientMapper
 * @author: Ada
 * @date 2019/10/31 11:44
 * @Description:
 */
public interface ClientMapper extends Mapper<Client> {
    List<String> selectAllowedClient(String serviceId);

    List<Client> selectAuthorityServiceInfo(int clientId);
}
