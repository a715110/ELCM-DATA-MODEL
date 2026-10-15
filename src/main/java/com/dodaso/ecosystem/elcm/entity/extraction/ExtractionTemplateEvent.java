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
 * Maps to elcm.extraction_template_event (ADDED 2026-10-14): one row for every change to an
 * extraction template (draft created, draft saved, published, draft discarded). Append only, kept
 * by template name so the history survives a discarded draft. See
 * extraction_template_management.sql.
 */
@Entity
@Table(name = "extraction_template_event")
@Getter
@Setter
public class ExtractionTemplateEvent implements Serializable {

  public static final String IMPORTED = "IMPORTED";
  public static final String DRAFT_CREATED = "DRAFT_CREATED";
  public static final String DRAFT_SAVED = "DRAFT_SAVED";
  public static final String DRAFT_DISCARDED = "DRAFT_DISCARDED";
  public static final String PUBLISHED = "PUBLISHED";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "template_name", nullable = false, length = 150)
  private String templateName;

  @Column(name = "version_label", nullable = false, length = 20)
  private String versionLabel;

  /** The version row; no foreign key, so the event stays when a draft is deleted. */
  @Column(name = "template_id")
  private Long templateId;

  @Column(name = "event_type", nullable = false, length = 30)
  private String eventType;

  @Column(name = "reason", length = 500)
  private String reason;

  @Column(name = "summary", length = 2000)
  private String summary;

  @Column(name = "created_by", nullable = false, length = 255)
  private String createdBy;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;
}
