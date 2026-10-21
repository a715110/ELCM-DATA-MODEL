package com.dodaso.ecosystem.elcm.repository.approval;

import com.dodaso.ecosystem.elcm.entity.approval.ReviewNotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewNotationRepository extends JpaRepository<ReviewNotation, Long> {

    /** ADDED 2026-10-21 (purge job). Removes the review notations of a document. */
    @Modifying
    @Query("DELETE FROM ReviewNotation n WHERE n.stagedDocument.id = :documentId")
    int purgeByStagedDocumentId(@Param("documentId") Long documentId);
}
