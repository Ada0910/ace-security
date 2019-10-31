package com.ada.server.runner;

import com.ada.auth.common.util.RsaKeyHelperUtil;
import com.ada.server.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * @ClassName:AuthServerRunner
 * @author: Ada
 * @date 2019/10/31 17:08
 * @Description:
 */
@Configuration
public class AuthServerRunner implements CommandLineRunner {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
    private static final String REDIS_SERVICE_PRI_KEY = "AG:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "AG:AUTH:CLIENT:PUB";

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY) && redisTemplate.hasKey(REDIS_USER_PUB_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)) {
            keyConfiguration.setUserPriKey(RsaKeyHelperUtil.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY).toString()));
            keyConfiguration.setUserPubKey(RsaKeyHelperUtil.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
            keyConfiguration.setServicePriKey(RsaKeyHelperUtil.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString()));
            keyConfiguration.setServicePubKey(RsaKeyHelperUtil.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
        } else {
            Map<String, byte[]> keyMap = RsaKeyHelperUtil.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RsaKeyHelperUtil.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RsaKeyHelperUtil.toHexString(keyMap.get("pub")));
            keyMap = RsaKeyHelperUtil.generateKey(keyConfiguration.getServiceSecret());
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, RsaKeyHelperUtil.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, RsaKeyHelperUtil.toHexString(keyMap.get("pub")));

        }
    }
}
