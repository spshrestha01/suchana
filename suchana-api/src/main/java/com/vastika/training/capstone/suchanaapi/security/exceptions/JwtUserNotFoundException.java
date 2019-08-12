package com.vastika.training.capstone.suchanaapi.security.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtUserNotFoundException extends AuthenticationException {

    public JwtUserNotFoundException(String msg){
        super(msg);
    }
}
