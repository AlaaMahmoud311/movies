package com.demo.movies.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTGenerator {
    
    private final Environment env;
    
    public String generateToken(Authentication authentication){
        String email = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + Long.parseLong(env.getProperty("JWT_EXPIRATION")) );
        Key key = Keys.hmacShaKeyFor(env.getProperty("JWT_SECRET").getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder().setSubject(email).setIssuedAt(currentDate).setExpiration(expiryDate).signWith(key).compact();
        return token;
    }

    public boolean valdiateToken(String token){
        try{
            String secretKey = env.getProperty("JWT_SECRET");
            Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String getEmailFromToken(String token){
        String secretKey = env.getProperty("JWT_SECRET");
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        return  Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
}