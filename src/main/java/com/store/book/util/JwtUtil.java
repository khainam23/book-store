package com.store.book.util;

import com.store.book.pojo.UserDetailToken;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtUtil {
    @Value("${jwt.secret}")
    String jwtSecret;
    @Value("${jwt.expiration.time}")
    long jwtExpirationTime;
    @Value("${jwt.expiration.type}")
    String jwtExpirationType; // m - minutes, h - hour, d - day
    JsonUtil jsonUtil;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateJwtToken(UserDetailToken userDetailToken) {
        String transformUser = jsonUtil.convertObjToJson(userDetailToken);
        long expirationTypeForServer = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(transformUser)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expirationTypeForServer + jwtExpirationTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public UserDetailToken getUserDetailFromJwtToken(String token) {
        String jsonUser = Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return jsonUtil.convertJsonToObj(jsonUser, UserDetailToken.class);
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
        }
        return false;
    }
}
