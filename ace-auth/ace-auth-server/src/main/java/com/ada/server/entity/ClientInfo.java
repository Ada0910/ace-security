package com.ada.server.entity;

import com.ada.auth.common.util.IJWTInfoUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName:ClientInfo
 * @author: Ada
 * @date 2019/10/31 16:29
 * @Description:
 */
@Getter
@Setter
public class ClientInfo implements IJWTInfoUtil {
    String clientId;
    String name;
    String id;

    public ClientInfo(String clientId, String name, String id) {
        this.clientId = clientId;
        this.name = name;
        this.id = id;
    }

    @Override
    public String getUniqueName() {
        return clientId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
