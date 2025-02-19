package com.DatNguyen.ImageGenerator.Service.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    @Value("${jwt_secret_key}")
    private String SECRET_KEY;

    // Secret Key
    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Extract all claims
    private Claims extractAllClaims(String jwtToken){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    // Extract 1 claim from the extracted claims
    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(jwtToken);
        return claimResolver.apply(claims);
    }

    // Extract email
    public String extractEmail(String jwtToken){
        return extractClaim(jwtToken, Claims::getSubject);
    }

    // Token generate
    public String tokenGenerator(Map<String, Object> extraClaims, UserDetails userDetails, long time){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                // Set token live
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + time)) // 24 hours
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // Algorithm for 256-bit hash
                .compact(); // Generate and return token
    }
    // Overloading to make tokenGenerator easier to access (only UserDetails param)
    public String tokenGenerator(UserDetails userDetails, long time){
        return tokenGenerator(new HashMap<>(), userDetails, time);
    }

    // Extract Expiration from specified claim
    public Date extractExpiration(String jwtToken){
        return extractClaim(jwtToken, Claims::getExpiration);
    }

    // Check if token is expired
    public boolean isExpiredToken(String jwtToken){
        return (extractExpiration(jwtToken).before(new Date()));
    }

    // check if token is valid
    public boolean isTokenValidate(String jwtToken, UserDetails userDetails){
        String email = extractEmail(jwtToken);
        return email.equals(userDetails.getUsername()) && !isExpiredToken(jwtToken);
    }
}