package com.dodaso.ecosystem.elcm.entity.extraction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.extraction_control (ADDED 2026-10-18): a single row, id 1, that says whether the
 * extraction agent is paused, by whom, since when and why. Kept in the database so a pause survives
 * a restart. See extraction_control.sql.
 */
@Entity
@Table(name = "extraction_control")
@Getter
@Setter
public class ExtractionControl implements Serializable {

  /** The id of the one row. */
  public static final long SINGLETON_ID = 1L;

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "paused", nullable = false)
  private Boolean paused = Boolean.FALSE;

  @Column(name = "paused_by", length = 100)
  private String pausedBy;

  @Column(name = "paused_at")
  private LocalDateTime pausedAt;

  @Column(name = "reason", length = 500)
  private String reason;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
