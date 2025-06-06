package com.suicide.codeConnect_api.jwt;


import com.suicide.codeConnect_api.entity.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
public class JwtUtils {

    public static final String JWT_BEARER = "Bearer";
    public static final String JWT_AUTHORIZATION = "Authorization";
    public static final String SECRET_KEY = "0123456789-0123456789-0123456789";
    public static final long EXPIRE_DAYS = 0;
    public static final long EXPIRE_HOURS = 0;
    public static final long EXPIRE_MINUTES = 20;

    private JwtUtils(){

    }

    private static Key generatedKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    private static Date toExpireDate(Date start){
        LocalDateTime dateTime = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = dateTime.plusDays(EXPIRE_DAYS).plusHours(EXPIRE_HOURS).plusMinutes(EXPIRE_MINUTES);
        return Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static JwtToken createToken(Usuario usuario){
        Date issueAt = new Date();
        Date limit = toExpireDate(issueAt);

        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(usuario.getEmail())
                .claim("id", usuario.getId())
                .setIssuedAt(issueAt)
                .setExpiration(limit)
                .signWith(generatedKey(), SignatureAlgorithm.HS256)
                .compact();

        return new JwtToken(token);

    }

    private static Claims getClaimFromToken(String token){
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(generatedKey()).build()
                    .parseClaimsJws(refactorToken(token)).getBody();
        } catch (JwtException ex){
            log.error(String.format("Token invalido %s", ex.getMessage()));
        }
        return null;
    }

    public static String getEmailFromToken(String token){
        return getClaimFromToken(token).getSubject();
    }

    public static boolean isTokenValid(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(generatedKey()).build()
                    .parseClaimsJws(refactorToken(token));
            return true;
        } catch (JwtException ex){
            log.error(String.format("Token invalido %s", ex.getMessage()));
        }
        return false;
    }

    private static String refactorToken(String token){
        if(token.startsWith(JwtUtils.JWT_BEARER + " ")){
            return token.substring((JwtUtils.JWT_BEARER + " ").length());
        }
        return token;
    }
}
