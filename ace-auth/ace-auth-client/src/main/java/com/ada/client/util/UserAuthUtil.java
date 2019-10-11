package com.ada.client.util;

import com.ada.auth.common.util.IJWTInfoUtil;
import com.ada.client.config.UserAuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ada
 * @ClassName :UserAuthUtil
 * @date 2019/10/10 22:00
 * @Description:
 */
@Configuration
public class UserAuthUtil {

    @Autowired
    private UserAuthConfig userAuthConfig;

    public IJWTInfoUtil getInfoFromToken(String token){
        return null;
    }
}
