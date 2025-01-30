package com.DatNguyen.ImageGenerator.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_subscriptions")
public class UserSubscriptions {
    @Id
    @Column(name = "subscription_id")
    private UUID subscriptionID;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private SubscriptionPlans subscriptionPlan;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    public UserSubscriptions(){}

    public UserSubscriptions(UUID subscriptionID, Timestamp startDate, Timestamp endDate, String paymentStatus) {
        this.subscriptionID = subscriptionID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentStatus = paymentStatus;
    }

    public UUID getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(UUID subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public SubscriptionPlans getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlans subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

