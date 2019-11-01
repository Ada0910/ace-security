package com.ada.auth.common.util;

import com.ada.auth.common.constant.CommonConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * @ClassName:JWTHelper
 * @author: Ada
 * @date 2019/10/11 16:37
 * @Description: Token信息处理工具类
 */
public class JWTHelperUtil {
    private static RsaKeyHelperUtil rsaKeyHelper = new RsaKeyHelperUtil();

    /**
     * 生成密钥加密token
     */
    public static String generateToken(IJWTInfoUtil jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(CommonConstant.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstant.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 生成密钥加密token
     */
    public static String generateToken(IJWTInfoUtil jwtInfo, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(CommonConstant.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstant.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
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

    /**
     * 获取token中的用户信息
     */
    public static IJWTInfoUtil getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfoUtil(body.getSubject(), StringHelperUtil.getObjectValue(body.get(CommonConstant.JWT_KEY_USER_ID)), StringHelperUtil.getObjectValue(body.get(CommonConstant.JWT_KEY_NAME)));
    }
}
