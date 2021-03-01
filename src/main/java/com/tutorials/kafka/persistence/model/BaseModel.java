package com.tutorials.kafka.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp dateCreated;

    private Timestamp lastUpdated;

    @PreUpdate
    @PrePersist
    public void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
        if (dateCreated == null) {
            dateCreated = new Timestamp(System.currentTimeMillis());
        }
    }
}
