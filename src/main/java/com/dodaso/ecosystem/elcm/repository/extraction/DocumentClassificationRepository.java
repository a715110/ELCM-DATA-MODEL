package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.DocumentClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentClassificationRepository extends JpaRepository<DocumentClassification, Long> {

    /** ADDED 2026-10-21 (purge job). Removes the classifications of a document. */
    @Modifying
    @Query("DELETE FROM DocumentClassification c WHERE c.stagedDocument.id = :documentId")
    int purgeByStagedDocumentId(@Param("documentId") Long documentId);
}
