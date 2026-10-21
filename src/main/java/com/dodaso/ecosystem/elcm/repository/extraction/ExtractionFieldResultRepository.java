package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionFieldResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExtractionFieldResultRepository extends JpaRepository<ExtractionFieldResult, Long> {

    /** A job's results with the template field loaded, in the template's display order. */
    @Query("SELECT r FROM ExtractionFieldResult r JOIN FETCH r.templateField f "
        + "WHERE r.job.id = :jobId ORDER BY f.displayOrder")
    List<ExtractionFieldResult> findDetailedByJobId(@Param("jobId") Long jobId);

    void deleteByJob_Id(Long jobId);

    /** ADDED 2026-10-21 (purge job). Removes the field results of every job of a document. */
    @Modifying
    @Query("DELETE FROM ExtractionFieldResult f WHERE f.job.id IN "
        + "(SELECT j.id FROM ExtractionJob j WHERE j.stagedDocument.id = :documentId)")
    int purgeByStagedDocumentId(@Param("documentId") Long documentId);
}
