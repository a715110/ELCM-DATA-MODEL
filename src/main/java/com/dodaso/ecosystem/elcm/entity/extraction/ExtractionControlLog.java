package com.dodaso.ecosystem.elcm.entity.extraction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.extraction_control_log (ADDED 2026-10-18): one row for every Pause, Resume and Stop
 * of the extraction agent, with who and why. Append only. package_id and submission_id are plain
 * numbers, not relations, so the history stays when a submission is deleted (unsubmit). See
 * extraction_control.sql.
 */
@Entity
@Table(name = "extraction_control_log")
@Getter
@Setter
public class ExtractionControlLog implements Serializable {

  /** PAUSE, RESUME or STOP. */
  public static final String ACTION_PAUSE = "PAUSE";

  public static final String ACTION_RESUME = "RESUME";
  public static final String ACTION_STOP = "STOP";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "action", nullable = false, length = 20)
  private String action;

  /** Null for Pause and Resume. */
  @Column(name = "package_id")
  private Long packageId;

  /** Null for Pause and Resume. */
  @Column(name = "submission_id")
  private Long submissionId;

  @Column(name = "actor", length = 100)
  private String actor;

  @Column(name = "reason", length = 500)
  private String reason;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;
}
