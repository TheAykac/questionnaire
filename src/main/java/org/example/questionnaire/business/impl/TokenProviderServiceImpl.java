package org.example.questionnaire.business.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.questionnaire.business.service.TokenProviderService;
import org.example.questionnaire.dataAccess.UserLoginRepository;
import org.example.questionnaire.dtos.response.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenProviderServiceImpl implements TokenProviderService {
    private final UserLoginRepository userLoginRepository;
    @Value("${jwt-secret-key}")
    private String SECRET;

    @Override
    public TokenResponse generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 30);
        String token = createToken(claims, userName, expirationDate);
        return new TokenResponse(token, expirationDate);
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUser(token);
        Date expirationDate = extractExpiration(token);
        boolean isActive = userLoginRepository.existsByAccessTokenAndActive(token, true);
        return userDetails.getUsername().equals(username) && !expirationDate.before(new Date()) && isActive;
    }


    @Override
    public Date extractExpiration(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();
    }

    @Override
    public String extractUser(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    private String createToken(Map<String, Object> claims, String userName, Date expirationDate) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("access_token");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    @Override
    public Authentication getAuthentication(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password, null);
    }
}
