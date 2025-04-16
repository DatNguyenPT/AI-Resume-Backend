package com.DatNguyen.AuthService.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // User Not Found Exception
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> UsernameNotFoundException(UsernameNotFoundException ex) {
        logger.error("User not found{}", ex.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("error", "User Not Found");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Authentication Credentials Not Found Exception
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<Map<String, String>> AuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException ex) {
        logger.error("Wrong credentials{}", ex.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("error", "Wrong credentials");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // Other Authentication Exceptions
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> AuthenticationException(AuthenticationException ex) {
        logger.error("Authentication error {}", ex.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("error", "Authentication error");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // Mail Exceptions
    @ExceptionHandler(MailException.class)
    public ResponseEntity<Map<String, String>> MailException(MailException ex) {
        logger.error("Mail error {}", ex.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("error", "Mail error");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
