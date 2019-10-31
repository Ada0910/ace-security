package com.ada.server.util.client;

import com.ada.auth.common.util.IJWTInfoUtil;
import com.ada.auth.common.util.JWTHelperUtil;
import com.ada.server.configuration.KeyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:ClientTokenUtil
 * @author: Ada
 * @date 2019/10/31 17:01
 * @Description:
 */
@Configuration
public class ClientTokenUtil {
    private Logger logger = LoggerFactory.getLogger(ClientTokenUtil.class);

    @Value("${client.expire}")
    private int expire;
    @Autowired
    private KeyConfiguration keyConfiguration;

    public String generateToken(IJWTInfoUtil jwtInfo) throws Exception {
        return JWTHelperUtil.generateToken(jwtInfo, keyConfiguration.getServicePriKey(), expire);
    }

    public IJWTInfoUtil getInfoFromToken(String token) throws Exception {
        return JWTHelperUtil.getInfoFromToken(token, keyConfiguration.getServicePubKey());
    }
}
