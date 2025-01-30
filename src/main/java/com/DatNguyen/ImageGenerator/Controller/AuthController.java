package com.DatNguyen.ImageGenerator.Controller;

import com.DatNguyen.ImageGenerator.Entity.LoginForm;
import com.DatNguyen.ImageGenerator.Entity.RegisterForm;
import com.DatNguyen.ImageGenerator.Service.JWT.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm form) {
        return new ResponseEntity<>(authService.registration(form), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form) {
        return new ResponseEntity<>(authService.authenticate(form), HttpStatus.OK);
    }

    @GetMapping("/otp")
    public ResponseEntity<?> otp(@RequestParam String email) {
        return new ResponseEntity<>(authService.sendOTP(email), HttpStatus.OK);
    }
}
