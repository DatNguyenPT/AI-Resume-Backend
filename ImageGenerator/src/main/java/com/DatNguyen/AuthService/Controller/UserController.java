package com.DatNguyen.AuthService.Controller;

import com.DatNguyen.AuthService.Entity.Users;
import com.DatNguyen.AuthService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userID}")
    public Users getUserByEmail(@PathVariable UUID userID) {
        return userService.getUserById(userID);
    }
}
