package com.twy.springbootjwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/**
 * @author gongpeng
 * @date 2020/9/1 15:52
 */
public class JwtUtil {
    //过期时间1分钟
    private static final long EXPIRE_TIME = 1;

    //生成签名,1分钟后过期
    public static String sign(Long userId, String userName, String password) {
        //过期时间
        LocalDateTime dateTime = LocalDateTime.now().plus(EXPIRE_TIME, ChronoUnit.MILLIS);
        //使用用户密码作为私钥进行加密
        Algorithm algorithm = Algorithm.HMAC256(password);
        //设置头信息        
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("userId", userId).withClaim("userName", userName)
                .sign(algorithm);
    }

    public static boolean verity(String token, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
