package com.DatNguyen.ImageGenerator.Repository;

import com.DatNguyen.ImageGenerator.Entity.UserSubscriptions;
import com.DatNguyen.ImageGenerator.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository
public interface UserSubscriptionRepo extends JpaRepository<UserSubscriptions, Integer> {
    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Users findByEmail(@Param("email") String email);

    @Query("SELECT s.planID FROM SubscriptionPlans s WHERE s.planName = :planName")
    UUID getPlanID(@Param("planName") String planName);

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO user_subscriptions (subscription_id, user_id, plan_id, start_date, end_date, payment_status)
        VALUES (:subscriptionId, :userId, :planId, :startDate, :endDate, :paymentStatus)
        ON CONFLICT (subscription_id) 
        DO UPDATE SET 
            end_date = EXCLUDED.end_date,
            payment_status = EXCLUDED.payment_status
        """, nativeQuery = true)
    void upsertSubscription(UUID subscriptionId, UUID userId, UUID planId,
                            Timestamp startDate, Timestamp endDate, String paymentStatus);
}
