package com.dodaso.ecosystem.elcm.entity.pipeline;

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
 * Maps to elcm.submission_send_back (ADDED 2026-10-14): one row each time an approver sends a
 * completed review back to the reviewer, with the reason. Append only: rows are never updated or
 * deleted, so a package sent back several times keeps every reason. See submission_send_back.sql.
 */
@Entity
@Table(name = "submission_send_back")
@Getter
@Setter
public class SubmissionSendBack implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "submission_id", nullable = false)
  private Submission submission;

  @Column(name = "reason", nullable = false, length = 1000)
  private String reason;

  @Column(name = "sent_by", nullable = false, length = 255)
  private String sentBy;

  @Column(name = "sent_at", nullable = false)
  private LocalDateTime sentAt;
}
