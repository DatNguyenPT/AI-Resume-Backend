package com.DatNguyen.Subscription_Service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_subscriptions")
@AllArgsConstructor
@NoArgsConstructor
public class UserSubscriptions {
    @Id
    @Column(name = "subscription_id")
    private UUID subscriptionID;

    @Column(name = "user_id")
    private UUID userID;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "payment_status")
    private String paymentStatus;
}

