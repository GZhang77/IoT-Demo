package com.iot.sensor.service;

import com.iot.sensor.Constant.TokenConstant;
import com.iot.sensor.model.User;
import com.iot.sensor.security.UserAuthentication.UserAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + TokenConstant.tokenExpiration);

        String subject = user.getId().toString();

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, TokenConstant.tokenSecret)
                .compact();
    }
}
