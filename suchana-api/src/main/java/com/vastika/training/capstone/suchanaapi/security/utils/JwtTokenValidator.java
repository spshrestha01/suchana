package com.vastika.training.capstone.suchanaapi.security.utils;

import com.vastika.training.capstone.suchanaapi.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

@Slf4j
@Component
public class JwtTokenValidator {

    @Value("${jwt.secret}")
    private String secret;

    public JwtUserDto parseToken(String token) {
        JwtUserDto u = null;
        try {
            Claims body = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(token).getBody();

            u = new JwtUserDto(Integer.valueOf((String)body.get("userId")), body.getSubject(), (String) body.get("role"));
        }catch (JwtException e){
            log.error("Exception while parsing token: {}", e);
        }
        return u;
    }

}
