package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpSubmissionStatus;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Maps to elcm.submission -- generated from the authoritative dodaso-platform.dbs schema (elcm.sql
 * export), not hand-written. Relationships are unidirectional (owning side only, no inverse
 * @OneToMany collections) to keep this first pass simple -- add inverse collections later only
 * where a real query need shows up for one. All @ManyToOne/@OneToOne use FetchType.LAZY
 * deliberately (JPA defaults @ManyToOne to EAGER, which is usually wrong). created_at/updated_at
 * are insertable=false, updatable=false -- the database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP
 * owns those values, not the application.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "submission")
@Getter
@Setter
public class Submission implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "package_id", nullable = false)
  private ContractPackage contractPackage;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id", nullable = false)
  private LkpSubmissionStatus status;

  @Column(name = "submitted_by", nullable = false, length = 255)
  private String submittedBy;

  @Column(name = "submitted_at", nullable = false)
  private LocalDateTime submittedAt;

  @Column(name = "claimed_by", length = 255)
  private String claimedBy;

  @Column(name = "claimed_at")
  private LocalDateTime claimedAt;

  /**
   * ADDED 2026-10-12 -- set when a reviewer declines the package back to Assembly (see
   * decline_status.sql).
   */
  @Column(name = "decline_reason", length = 1000)
  private String declineReason;

  @Column(name = "declined_by", length = 255)
  private String declinedBy;

  @Column(name = "declined_at")
  private LocalDateTime declinedAt;

  /**
   * ADDED 2026-10-12 -- who last reopened a completed review and when (see reopen_review.sql).
   */
  @Column(name = "reopened_by", length = 255)
  private String reopenedBy;

  @Column(name = "reopened_at")
  private LocalDateTime reopenedAt;

  /**
   * ADDED 2026-10-13 -- who completed the review and when; the approver must be someone else (see
   * approver_step.sql).
   */
  @Column(name = "reviewed_by", length = 255)
  private String reviewedBy;

  @Column(name = "reviewed_at")
  private LocalDateTime reviewedAt;

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