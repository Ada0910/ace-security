package com.ada.auth.common.util;

import com.ada.auth.common.constant.CommonConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

/**
 * @ClassName:JWTHelper
 * @author: Ada
 * @date 2019/10/11 16:37
 * @Description:
 */
public class JWTHelperUtil {
    private static RsaKeyHelperUtil rsaKeyHelper = new RsaKeyHelperUtil();

    /**
     * 公钥解析
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     */
    public static IJWTInfoUtil getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfoUtil(body.getSubject(), StringHelperUtil.getObjectValue(body.get(CommonConstant.JWT_KEY_USER_ID)), StringHelperUtil.getObjectValue(body.get(CommonConstant.JWT_KEY_NAME)));
    }

    /**
     * 公钥解析token
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     */
    public static IJWTInfoUtil getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new JWTInfoUtil(body.getSubject(), StringHelperUtil.getObjectValue(body.get(CommonConstant.JWT_KEY_USER_ID)), StringHelperUtil.getObjectValue(body.get(CommonConstant.JWT_KEY_NAME)));
    }
}
