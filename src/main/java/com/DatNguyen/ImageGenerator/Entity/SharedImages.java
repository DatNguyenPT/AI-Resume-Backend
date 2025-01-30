package com.DatNguyen.ImageGenerator.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "shared_images")
public class SharedImages {
    @Id
    private UUID sharedID;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    private GeneratedImages image;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "shared_with", nullable = false)
    private UUID sharedWith;

    @Column(name = "shared_at", nullable = false)
    private Timestamp sharedAt;

    @Column(name = "access_level", nullable = false)
    private String accessLevel;
}
