package com.DatNguyen.ImageGenerator.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "generated_image")
public class GeneratedImages {
    @Id
    private UUID imageID;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String prompt;

    @Column(name = "model_version", nullable = false)
    private String modelVersion;

    @Column(name = "storage_path", nullable = false)
    private String storagePath;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String resolution;
}
