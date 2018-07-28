package com.common.user.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

/**
 * Author：xiongzhan
 * Description：JsonWebToken
 * Date: 2018-07-28 15:19
 */
public class JsonWebTokenUtility {

    private static SignatureAlgorithm signatureAlgorithm;

    private static Key secretKey;


    public JsonWebTokenUtility() {


        // 这里不是真正安全的实践

        // 为了简单，我们存储一个静态key在这里，

        // 在真正微服务环境，这个key将会被保留在配置服务器

        signatureAlgorithm = SignatureAlgorithm.HS512;

        String encodedKey =

                "L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg==";

        secretKey = deserializeKey(encodedKey);

    }



    public static String createJsonWebToken(AuthTokenDetailsDTO authTokenDetailsDTO)

    {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, 1);

        String token =

                Jwts.builder().setSubject(authTokenDetailsDTO.getUserId())

                        .claim("lenderId", authTokenDetailsDTO.getLenderId())

                        .claim("name", authTokenDetailsDTO.getName())

                        .claim("productCode", authTokenDetailsDTO.getProductCode())

                        .setExpiration(calendar.getTime())

                        .signWith(getSignatureAlgorithm(),

                                getSecretKey()).compact();

        return token;

    }



    private Key deserializeKey(String encodedKey) {

        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);

        Key key =

                new SecretKeySpec(decodedKey, getSignatureAlgorithm().getJcaName());

        return key;

    }


    private static Key getSecretKey() {

        return secretKey;

    }


    public static SignatureAlgorithm getSignatureAlgorithm() {

        return signatureAlgorithm;

    }


    public AuthTokenDetailsDTO parseAndValidate(String token) {

        AuthTokenDetailsDTO authTokenDetailsDTO = null;

        try {

            Claims claims =

                    Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();

            String userId = claims.getSubject();

            String lenderId = (String) claims.get("lenderId");

            String name = (String) claims.get("name");

            String productCode = (String) claims.get("productCode");

//            List roleNames = (List) claims.get("roles");

            Date expirationDate = claims.getExpiration();



            authTokenDetailsDTO = new AuthTokenDetailsDTO();

            authTokenDetailsDTO.setUserId(userId);

            authTokenDetailsDTO.setLenderId(lenderId);

            authTokenDetailsDTO.setName(name);

            authTokenDetailsDTO.setProductCode(productCode);

            authTokenDetailsDTO.setExpirationDate(expirationDate);
        } catch (JwtException ex) {

            System.out.println(ex);

        }

        return authTokenDetailsDTO;

    }


    private String serializeKey(Key key) {

        String encodedKey =

                Base64.getEncoder().encodeToString(key.getEncoded());

        return encodedKey;

    }

    public static void main(String[] args) {
        JsonWebTokenUtility jsonWebTokenUtility = new JsonWebTokenUtility();
        AuthTokenDetailsDTO authTokenDetailsDTO = new AuthTokenDetailsDTO();
        authTokenDetailsDTO.setUserId("123456");
        authTokenDetailsDTO.setName("熊湛");
        authTokenDetailsDTO.setLenderId("fs_0001");
        authTokenDetailsDTO.setProductCode("cigar");
        String token = jsonWebTokenUtility.createJsonWebToken(authTokenDetailsDTO);
        System.out.println(token);
        //解密
        authTokenDetailsDTO = jsonWebTokenUtility.parseAndValidate(token);
        System.out.println(authTokenDetailsDTO);
    }

}
