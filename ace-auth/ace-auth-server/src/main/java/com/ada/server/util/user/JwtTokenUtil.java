package com.ada.server.util.user;


import com.ada.auth.common.util.IJWTInfoUtil;
import com.ada.auth.common.util.JWTHelperUtil;
import com.ada.server.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName:JwtTokenUtil
 * @author: Ada
 * @date 2019/10/29 17:34
 * @Description:
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.expire}")
    private int expire;//过期时间

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String generateToken(IJWTInfoUtil ijwtInfoUtil) throws Exception {
        return JWTHelperUtil.generateToken(ijwtInfoUtil, keyConfiguration.getUserPriKey(), expire);

    }

    public IJWTInfoUtil getInfoFromToken(String token) throws Exception {
        return JWTHelperUtil.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }

}
