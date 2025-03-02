package com.DatNguyen.AuthService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
public class SubscriptionRequest {
    UUID userID;
    String paymentStatus;

    public SubscriptionRequest(){}
    public SubscriptionRequest(UUID userID, String paymentStatus) {
        this.userID = userID;
        this.paymentStatus = paymentStatus;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
