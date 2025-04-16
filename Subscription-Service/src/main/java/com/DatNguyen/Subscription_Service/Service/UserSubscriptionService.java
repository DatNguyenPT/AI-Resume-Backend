package com.DatNguyen.Subscription_Service.Service;
import com.DatNguyen.Subscription_Service.Entity.SubscriptionRequest;
import com.DatNguyen.Subscription_Service.Entity.UserResponse;
import com.DatNguyen.Subscription_Service.Repository.UserSubscriptionRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class UserSubscriptionService {
    @Autowired
    private UserSubscriptionRepo userSubscriptionRepo;


    @Transactional
    public boolean createNewUserSubscription(SubscriptionRequest subscriptionRequest) {
        UUID subscriptionID = UUID.randomUUID();
        UUID userID = subscriptionRequest.getUserID();
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plus(30, ChronoUnit.DAYS);
        Timestamp startTimestamp = Timestamp.valueOf(startDate);
        Timestamp endTimestamp = Timestamp.valueOf(endDate);
        String paymentStatus = subscriptionRequest.getPaymentStatus();

        try {
            userSubscriptionRepo.upsertSubscription(subscriptionID, userID, startTimestamp, endTimestamp, paymentStatus);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}

