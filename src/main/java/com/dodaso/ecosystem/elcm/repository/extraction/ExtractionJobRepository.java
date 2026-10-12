package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionJob;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExtractionJobRepository extends JpaRepository<ExtractionJob, Long> {

    /** The newest job of one document (a document can be retried, so there can be several). */
    Optional<ExtractionJob> findFirstByStagedDocument_IdOrderByIdDesc(Long stagedDocumentId);

    /** Jobs of a set of documents with status, template and document loaded (read after the transaction ends). */
    @Query("SELECT j FROM ExtractionJob j "
        + "JOIN FETCH j.status JOIN FETCH j.template JOIN FETCH j.stagedDocument "
        + "WHERE j.stagedDocument.id IN :ids ORDER BY j.id")
    List<ExtractionJob> findDetailedByStagedDocumentIds(@Param("ids") Collection<Long> stagedDocumentIds);

    /** Puts jobs that were RUNNING back to QUEUED (used when a crashed worker's submission is recovered). */
    @Modifying
    @Query("UPDATE ExtractionJob j SET j.status = :queued WHERE j.status = :running AND j.stagedDocument.id IN :ids")
    int requeueRunning(@Param("queued") com.dodaso.ecosystem.elcm.entity.lookup.LkpExtractionJobStatus queued,
                       @Param("running") com.dodaso.ecosystem.elcm.entity.lookup.LkpExtractionJobStatus running,
                       @Param("ids") Collection<Long> stagedDocumentIds);
}
