package com.DatNguyen.ImageGenerator.Service.JWT;

import com.DatNguyen.ImageGenerator.Entity.*;
import com.DatNguyen.ImageGenerator.Repository.UserRepo;
import com.DatNguyen.ImageGenerator.Service.EmailService;
import com.DatNguyen.ImageGenerator.Service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserSubscriptionService userSubscriptionService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmailService emailService;

    public Map<String, String>createTokens(Users user) {
        String accessToken = jwtService.tokenGenerator(user);
        String refreshToken = jwtService.tokenGenerator(user);
        Map<String, String>tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        return tokens;
    }

    public AuthenticationResponse registration(RegisterForm registerForm){
        if(userRepo.findByEmail(registerForm.getEmail()) != null){
            throw new RuntimeException("Username already exists");
        }

        if (!registerForm.getPassword().equals(registerForm.getRetypePassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        String username = registerForm.getUsername();
        String email = (registerForm.getEmail());
        String hashedPassword = passwordEncoder.encode(registerForm.getPassword());
        UUID userID = UUID.randomUUID();
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp lastLogin = new Timestamp(System.currentTimeMillis());
        boolean isVerified = true;
        Role role = Role.FREE;

        Users newUser = new Users(userID, username, email, hashedPassword, createdAt, lastLogin, isVerified, role);
        userRepo.save(newUser);

        try {
            Thread.sleep(20 * 1000); // Delay for 20 seconds
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        boolean userSubscription = userSubscriptionService.createNewUserSubscription(userID, "paid");

        if(!userSubscription){
            throw new RuntimeException("User subscription could not be created");
        }
        Map<String, String> tokens = createTokens(newUser);
        return new AuthenticationResponse(tokens);
    }

    public AuthenticationResponse authenticate(LoginForm loginForm) {
        Users user = userRepo.findByEmail(loginForm.getEmail());

        if (user == null || !passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getEmail(),
                        loginForm.getPassword()
                )
        );

        Map<String, String> tokens = createTokens(user);

        return new AuthenticationResponse(tokens);
    }

    public String sendOTP(String email) {
        String otp = emailService.sendOTP(email);
        if(otp.isEmpty()){
            throw new RuntimeException("OTP could not be sent");
        }
        return otp;
    }

}