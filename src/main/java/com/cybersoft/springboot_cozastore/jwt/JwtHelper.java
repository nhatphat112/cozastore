package com.cybersoft.springboot_cozastore.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;

@Component
public class JwtHelper {
    @Value("${jwt.secret.key}")
    private String key;

    public String generateKey(){
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Encoders.BASE64.encode(secretKey.getEncoded());
    }
    public String generateToken(String data){
        try {
            Key key1 = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
            String jwt = Jwts.builder()
                    .signWith(key1)
                    .setSubject(data)
                    .compact();
            return jwt;

        }catch (Exception e){

        }
        return null;

    }
    public Claims decodeToken(String token){
        Key key1 = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key1)
                    .build().parseClaimsJws(token)
                    .getBody();
            return claims;
        }catch (Exception e){

        }
        return null;
    }
}
