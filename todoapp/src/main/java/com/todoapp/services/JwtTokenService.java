package com.todoapp.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class JwtTokenService implements TokenService {

    @Value("${token.jwt.secret}")
    private String tokenSecret;

    @Value("${token.expiration.hours}")
    private Integer expirationHours;

    @Override
    public String generateToken(UserDetails user) {
        Date expiration = Date.from(LocalDateTime.now().plusHours(expirationHours).toInstant(ZoneOffset.UTC));
        Key key = Keys.hmacShaKeyFor(tokenSecret.getBytes());
        return Jwts.builder()
                .claim("username", user.getUsername())
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    @Override
    public boolean isValid(String token) {
        Claims claims = getAllClaims(token);
        Date expiration = claims.getExpiration();
        return expiration.after(new Date());
    }

    @Override
    public String extractUsername(String token) {
        Claims claims = getAllClaims(token);
        return claims.get("username", String.class);
    }

    public Claims getAllClaims(String token) {
        Key key = Keys.hmacShaKeyFor(tokenSecret.getBytes());
        JwtParser parser = Jwts.parser()
                .setSigningKey(key)
                .build();
       return parser.parseClaimsJws(token).getBody();
    }
}
