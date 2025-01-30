package com.DatNguyen.ImageGenerator.Service;
import com.DatNguyen.ImageGenerator.Entity.Users;
import com.DatNguyen.ImageGenerator.Repository.UserRepo;
import com.DatNguyen.ImageGenerator.Repository.UserSubscriptionRepo;
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
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public boolean createNewUserSubscription(UUID userID, String paymentStatus) {
        Users user = userRepo.findByUserID(userID);
        if (user == null) return false;

        UUID subscriptionID = UUID.randomUUID();
        UUID planID = userSubscriptionRepo.getPlanID(user.getRole().toString());
        System.out.println("Plan ID: " + planID);
        System.out.printf("User role: %s\n", user.getRole().toString());
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plus(30, ChronoUnit.DAYS);
        Timestamp startTimestamp = Timestamp.valueOf(startDate);
        Timestamp endTimestamp = Timestamp.valueOf(endDate);

        try {
            userSubscriptionRepo.upsertSubscription(subscriptionID, userID, planID, startTimestamp, endTimestamp, paymentStatus);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }





    








}
