package com.DatNguyen.Subscription_Service.Service;

import com.DatNguyen.Subscription_Service.Repository.SubscriptionPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubscriptionPlanService {
    @Autowired
    private SubscriptionPlanRepo subscriptionPlanRepo;
    @Value("${freeuuid}")
    private UUID freeUUID;
    @Value("${premiumuuid}")
    private UUID premiumUUID;

    public UUID getUUID(String role){
        return subscriptionPlanRepo.getUUID(role);
    }
}
