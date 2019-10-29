package com.ada.server.util.user;


import com.ada.server.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private int expire;

    @Autowired
    private KeyConfiguration keyConfiguration;
}
