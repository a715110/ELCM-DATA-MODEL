package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.DeletedStagedDocument;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * ADDED 2026-10-21 (purge job). Soft-deleted staged documents, see {@link DeletedStagedDocument}.
 */
public interface DeletedStagedDocumentRepository
    extends JpaRepository<DeletedStagedDocument, Long> {

  /** Deleted documents of one workspace whose delete time is before the cutoff, oldest first. */
  List<DeletedStagedDocument> findByWorkspace_CodeAndDeletedAtBeforeOrderByIdAsc(
      String workspaceCode, LocalDateTime cutoff, Pageable pageable);

  /**
   * Removes the row for good. A bulk statement, so the entity is never loaded or tracked. The
   * deleted-only restriction of the entity also applies, so an active document can never be removed
   * through here. Returns 1 when the row was removed.
   */
  @Modifying
  @Query("DELETE FROM DeletedStagedDocument d WHERE d.id = :id")
  int purgeById(@Param("id") Long id);
}
