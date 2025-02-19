package com.DatNguyen.ImageGenerator.Controller;

import com.DatNguyen.ImageGenerator.Entity.LoginForm;
import com.DatNguyen.ImageGenerator.Entity.RegisterForm;
import com.DatNguyen.ImageGenerator.Service.JWT.AuthService;
import com.DatNguyen.ImageGenerator.Service.JWT.BlackTokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private BlackTokenService blackTokenService;
    final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm form, HttpServletResponse response) {
        return new ResponseEntity<>(authService.registration(form, response), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form, HttpServletResponse response) {
        return new ResponseEntity<>(authService.authenticate(form, response), HttpStatus.OK);
    }

    @GetMapping("/otp")
    public ResponseEntity<?> otp(@RequestParam String email) {
        return new ResponseEntity<>(authService.sendOTP(email), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return ResponseEntity.badRequest().body("No cookies found");
        }

        String token = null;
        for (Cookie cookie : cookies) {
            if ("access_token".equals(cookie.getName())) {
                token = cookie.getValue();
                break;
            }
        }

        if (token == null) {
            return ResponseEntity.badRequest().body("No access token found");
        }

        try {
            long expirationMillis = authService.getExpirationDate(token).getTime();
            blackTokenService.blacklistToken(token, expirationMillis);
            return ResponseEntity.ok("Logout successful, token blacklisted");
        } catch (Exception e) {
            logger.error("Exception occurred during logout", e);
            return ResponseEntity.badRequest().body("Invalid or expired token");
        }
    }
}
