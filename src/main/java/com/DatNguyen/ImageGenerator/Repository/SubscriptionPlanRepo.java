package com.DatNguyen.ImageGenerator.Repository;

import com.DatNguyen.ImageGenerator.Entity.SubscriptionPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SubscriptionPlanRepo extends JpaRepository<SubscriptionPlans, Integer> {
    @Query("SELECT u.planID FROM SubscriptionPlans u WHERE u.planName = :planName")
    UUID getUUID(@Param("planName") String planName);
}
