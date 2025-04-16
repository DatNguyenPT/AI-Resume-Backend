package com.DatNguyen.Subscription_Service.Controller;

import com.DatNguyen.Subscription_Service.Entity.SubscriptionRequest;
import com.DatNguyen.Subscription_Service.Service.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @PostMapping("/create")
    public void createSubscription(@RequestBody SubscriptionRequest request) {
        userSubscriptionService.createNewUserSubscription(request);
    }
}