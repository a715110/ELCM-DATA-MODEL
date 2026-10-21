package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionFieldRevision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExtractionFieldRevisionRepository extends JpaRepository<ExtractionFieldRevision, Long> {

    /** A field's history, oldest first. */
    List<ExtractionFieldRevision> findByFieldResult_IdOrderByRevisionNoAsc(Long fieldResultId);

    /** Highest revision number of a field result, 0 when it has none yet. */
    @Query("SELECT COALESCE(MAX(r.revisionNo), 0) FROM ExtractionFieldRevision r WHERE r.fieldResult.id = :id")
    int maxRevisionNo(@Param("id") Long id);

    /** ADDED 2026-10-21 (purge job). Removes the revisions of every field result of a document. */
    @Modifying
    @Query("DELETE FROM ExtractionFieldRevision r WHERE r.fieldResult.id IN "
        + "(SELECT f.id FROM ExtractionFieldResult f WHERE f.job.stagedDocument.id = :documentId)")
    int purgeByStagedDocumentId(@Param("documentId") Long documentId);
}
