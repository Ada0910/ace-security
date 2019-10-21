package com.ada.client.util;

import com.ada.auth.common.util.IJWTInfoUtil;
import com.ada.auth.common.util.JWTHelperUtil;
import com.ada.client.config.UserAuthConfig;
import com.ada.common.exception.auth.UserTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.security.SignatureException;

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

    /**
     * 从token中拿用户的登录信息
     */
    public IJWTInfoUtil getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelperUtil.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new UserTokenException("User token expired!");
        } catch (SignatureException ex) {
            throw new UserTokenException("User token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new UserTokenException("User token is null or empty!");
        }
    }
}
