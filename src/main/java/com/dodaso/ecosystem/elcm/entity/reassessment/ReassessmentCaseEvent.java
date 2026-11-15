package com.dodaso.ecosystem.elcm.entity.reassessment;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * ADDED 2026-11-11 -- the history of a reassessment case: one row per step (opened, survey sent,
 * answered, concluded, approved, rejected, closed). Written by the application, never changed. This
 * is the case's own audit trail; it can be mirrored into the EARS activity log later without a
 * schema change.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reassessment_case_event")
@Getter
@Setter
public class ReassessmentCaseEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reassessment_case_id", nullable = false)
    private ReassessmentCase reassessmentCase;

    @Column(name = "event_code", nullable = false, length = 50)
    private String eventCode;

    @Column(name = "message", length = 1000)
    private String message;

    @Column(name = "actor", nullable = false, length = 255)
    private String actor;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 255)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
