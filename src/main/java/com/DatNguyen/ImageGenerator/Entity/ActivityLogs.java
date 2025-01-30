package com.DatNguyen.ImageGenerator.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "activity_logs")
public class ActivityLogs {
    @Id
    private UUID logID;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "activity_type", nullable = false)
    private String activityType;

    @Column(name = "activity_timestamp", nullable = false)
    private Timestamp activityTimestamp;

    @Column(nullable = false)
    private String metadata;
}

