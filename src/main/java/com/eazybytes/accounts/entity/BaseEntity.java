package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @Column(name = "updated_by", insertable = false)
    private String updatedBy;
}
