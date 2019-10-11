package com.ada.auth.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * @ClassName:JWTHelper
 * @author: Ada
 * @date 2019/10/11 16:37
 * @Description:
 */
public class JWTHelperUtil {
    private static RsaKeyHelperUtil rsaKeyHelper = new RsaKeyHelperUtil();

    /**公钥解析*/
    /**获取token中的用户信息*/
    public static IJWTInfoUtil getInfoFromToken(String token,String pubKeyPath){
        Jws<Claims> claimsJws  = parserToken(token,pubKeyPath);
    }
}
