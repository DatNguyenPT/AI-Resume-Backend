package com.DatNguyen.AuthService.FeignClient;

import com.DatNguyen.AuthService.Entity.SubscriptionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SUBSCRIPTION-SERVICE")
public interface SubscriptionClient {
    @PostMapping("/subscription/create")
    void createFreeSubscription(@RequestBody SubscriptionRequest request);
}
