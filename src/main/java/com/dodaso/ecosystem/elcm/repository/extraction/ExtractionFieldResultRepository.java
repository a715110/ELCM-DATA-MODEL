package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionFieldResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExtractionFieldResultRepository extends JpaRepository<ExtractionFieldResult, Long> {

    /** A job's results with the template field loaded, in the template's display order. */
    @Query("SELECT r FROM ExtractionFieldResult r JOIN FETCH r.templateField f "
        + "WHERE r.job.id = :jobId ORDER BY f.displayOrder")
    List<ExtractionFieldResult> findDetailedByJobId(@Param("jobId") Long jobId);

    void deleteByJob_Id(Long jobId);
}
