package com.DatNguyen.Subscription_Service.Repository;

import com.DatNguyen.Subscription_Service.Entity.SubscriptionPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SubscriptionPlanRepo extends JpaRepository<SubscriptionPlans, Integer> {
    @Query("SELECT u.planID FROM SubscriptionPlans u WHERE u.planName = :planName")
    UUID getUUID(@Param("planName") String planName);
}
