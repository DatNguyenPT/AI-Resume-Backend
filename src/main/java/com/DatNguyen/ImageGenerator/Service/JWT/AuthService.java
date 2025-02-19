package com.DatNguyen.ImageGenerator.Service.JWT;

import com.DatNguyen.ImageGenerator.Entity.*;
import com.DatNguyen.ImageGenerator.Repository.UserRepo;
import com.DatNguyen.ImageGenerator.Service.EmailService;
import com.DatNguyen.ImageGenerator.Service.UserSubscriptionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
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

    private final long accessTokenTTL = 1000L * 60 * 60 * 2;  // 2 hour
    private final long refreshTokenTTL = 1000L * 60 * 60 * 24 * 30; // 30 days


    public Date getExpirationDate(String token) {
        return jwtService.extractExpiration(token);
    }

    private Map<String, String>createTokens(Users user) {

        String accessToken = jwtService.tokenGenerator(user, accessTokenTTL);
        String refreshToken = jwtService.tokenGenerator(user, refreshTokenTTL);
        Map<String, String>tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        return tokens;
    }

    private void storeToken(String accessToken, String refeshToken, HttpServletResponse response) {
        int accessTokenTTLSeconds = (int) (accessTokenTTL / 1000);
        int refreshTokenTTLSeconds = (int) (refreshTokenTTL / 1000);

        Cookie accessTokenCookie = new Cookie("access_token", accessToken);
        accessTokenCookie.setMaxAge(accessTokenTTLSeconds);
        accessTokenCookie.setSecure(true);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/auth");


        response.addCookie(accessTokenCookie);

        Cookie refreshTokenCookie = new Cookie("refresh_token", refeshToken);
        refreshTokenCookie.setMaxAge(refreshTokenTTLSeconds);
        refreshTokenCookie.setSecure(true);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/auth");

        response.addCookie(refreshTokenCookie);
    }

    public AuthenticationResponse registration(RegisterForm registerForm, HttpServletResponse response){
        if(userRepo.findByEmail(registerForm.getEmail()) != null){
            throw new RuntimeException("Username already exists");
        }

        if (!registerForm.getPassword().equals(registerForm.getRetypePassword())) {
            throw new RuntimeException("Passwords are not match");
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
            Thread.sleep(10 * 1000); // Delay for 10 seconds
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        boolean userSubscription = userSubscriptionService.createNewUserSubscription(userID, "paid");

        if(!userSubscription){
            throw new RuntimeException("User subscription could not be created");
        }
        Map<String, String> tokens = createTokens(newUser);
        String accessToken = tokens.get("access_token");
        String refreshToken = tokens.get("refresh_token");

        storeToken(accessToken, refreshToken, response);


        return new AuthenticationResponse(tokens);
    }

    public AuthenticationResponse authenticate(LoginForm loginForm, HttpServletResponse response) {
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
        String accessToken = tokens.get("access_token");
        String refreshToken = tokens.get("refresh_token");

        storeToken(accessToken, refreshToken, response);

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