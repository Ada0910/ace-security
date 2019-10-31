package com.ada.server.biz;

import com.ada.common.biz.BaseBiz;
import com.ada.server.entity.Client;
import com.ada.server.entity.ClientService;
import com.ada.server.mapper.ClientMapper;
import com.ada.server.mapper.ClientServiceMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:ClientBiz
 * @author: Ada
 * @date 2019/10/31 11:43
 * @Description:
 */
@Service
public class ClientBiz extends BaseBiz<ClientMapper, Client> {

    @Autowired
    private ClientServiceMapper clientServiceMapper;
    @Autowired
    private ClientServiceBiz clientServiceBiz;

    public List<Client> getClientServices(int id) {
        return mapper.selectAuthorityServiceInfo(id);
    }

    public void modifyClientServices(int id, String clients) {
        clientServiceMapper.deleteByServiceId(id);
        if (!StringUtils.isEmpty(clients)) {
            String[] mem = clients.split(",");
            for (String m : mem) {
                ClientService clientService = new ClientService();
                clientService.setServiceId(m);
                clientService.setClientId(id + "");
                clientServiceBiz.insertSelective(clientService);
            }
        }
    }
}
