package com.DatNguyen.AuthService.Service;

import com.DatNguyen.AuthService.Entity.Users;
import com.DatNguyen.AuthService.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Users getUserByEmail(String email) {
        // Logger
        return userRepo.findByEmail(email);
    }

    public Users getUserById(UUID id) {
        return userRepo.findByUserID(id);
    }
}
