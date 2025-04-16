package com.DatNguyen.Subscription_Service.FeignClient;

import com.DatNguyen.Subscription_Service.Entity.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "AUTH-SERVICE")
public interface UserClient {
    @GetMapping("/user/{userId}")
    UserResponse getUserById(@PathVariable UUID userId);
}
