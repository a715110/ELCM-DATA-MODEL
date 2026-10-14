package com.dodaso.ecosystem.elcm.entity.extraction;

import com.dodaso.ecosystem.elcm.entity.pipeline.StagedDocument;
import com.dodaso.ecosystem.elcm.entity.pipeline.Submission;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.extraction_reprocess (ADDED 2026-10-14): one row each time a reviewer has one
 * document read again, with the reason. Append only. previous_job_id is the extraction job that was
 * set aside (SUPERSEDED); its results stay as history. See extraction_reprocess.sql.
 */
@Entity
@Table(name = "extraction_reprocess")
@Getter
@Setter
public class ExtractionReprocess implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "submission_id", nullable = false)
  private Submission submission;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "staged_document_id", nullable = false)
  private StagedDocument stagedDocument;

  @Column(name = "previous_job_id", nullable = false)
  private Long previousJobId;

  @Column(name = "reason", nullable = false, length = 500)
  private String reason;

  @Column(name = "requested_by", nullable = false, length = 255)
  private String requestedBy;

  @Column(name = "requested_at", nullable = false)
  private LocalDateTime requestedAt;
}
