package com.DatNguyen.Subscription_Service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlans {
    @Id
    @Column(name = "plan_id")
    private UUID planID;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(nullable = false, name = "price")
    private float price;

    @Column(name = "max_images", nullable = false)
    private int maxImages;

    @Column(name = "max_resolution", nullable = false)
    private String maxResolution;

    public SubscriptionPlans() {}

    public UUID getPlanID() {
        return planID;
    }

    public void setPlanID(UUID planID) {
        this.planID = planID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMaxImages() {
        return maxImages;
    }

    public void setMaxImages(int maxImages) {
        this.maxImages = maxImages;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

}

