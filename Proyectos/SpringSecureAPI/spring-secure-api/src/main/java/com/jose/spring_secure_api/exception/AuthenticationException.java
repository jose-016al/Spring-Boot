package com.jose.spring_secure_api.exception;

import lombok.Getter;

@Getter
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }

}
