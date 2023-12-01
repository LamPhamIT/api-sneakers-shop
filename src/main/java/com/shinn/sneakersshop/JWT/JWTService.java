//package com.shinn.sneakersshop.JWT;
//
//import com.shinn.sneakersshop.constant.JWTConstant;
//import com.shinn.sneakersshop.dto.UsersDto;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//public class JWTService {
//
//    public String generateToken(UsersDto usersDto) {
//        return buildToken(new HashMap<>(), usersDto, JWTConstant.JWT_EXPIRATION);
//    }
//
//    public String buildToken(Map<String, Object> extractClaims, UsersDto usersDto, int expiration) {
//        return Jwts.builder()
//                .setClaims(extractClaims)
//                .setIssuer("Sneaker shop")
//                .setSubject("JWT Token")
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(SignatureAlgorithm.HS512, JWTConstant.JWT_SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return null;
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//        Claims claims = extractAllClaims(token);
//        return  claimResolver.apply(claims);
//    }
//
//    public Claims extractAllClaims(String token) {
//        return Jwts
//                .parser()
//                .s
//
//    }
//
//}
