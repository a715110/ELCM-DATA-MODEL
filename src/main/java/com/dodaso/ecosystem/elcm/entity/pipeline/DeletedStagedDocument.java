package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

/**
 * ADDED 2026-10-21 (purge job). A read-only view of the soft-deleted rows of {@code
 * staged_document}.
 *
 * <p>{@link StagedDocument} carries {@code @SQLRestriction("deleted_at IS NULL")}, so every normal
 * query hides deleted documents, which is what the screens want. The purge job needs the opposite
 * set. This entity maps the same table with the opposite restriction, so the job can read deleted
 * rows through a repository without native SQL. Nothing else should use it, and it is never
 * saved: the only write is the delete done by {@code DeletedStagedDocumentRepository}.
 */
@Entity
@Table(name = "staged_document")
@SQLRestriction("deleted_at IS NOT NULL")
@Getter
@Setter
public class DeletedStagedDocument implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "file_upload_id", nullable = false)
  private Long fileUploadId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workspace_id", nullable = false, insertable = false, updatable = false)
  private Workspace workspace;

  @Column(name = "deleted_at", insertable = false, updatable = false)
  private LocalDateTime deletedAt;

  @Column(name = "deleted_by", length = 255, insertable = false, updatable = false)
  private String deletedBy;

  @Column(name = "delete_reason", length = 500, insertable = false, updatable = false)
  private String deleteReason;
}
