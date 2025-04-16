package com.DatNguyen.AuthService.Service;

import com.DatNguyen.AuthService.Entity.ForgotPassword;
import com.DatNguyen.AuthService.Entity.Users;
import com.DatNguyen.AuthService.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users getUserById(UUID id) {
        return userRepo.findByUserID(id);
    }

    public boolean forgotPassword(UUID id, ForgotPassword forgotPassword) {
        return userRepo.updateHashedPassword(passwordEncoder.encode(forgotPassword.getPassword()), id);
    }
}
