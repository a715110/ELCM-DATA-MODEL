package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionControlLog;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionControlLogRepository extends JpaRepository<ExtractionControlLog, Long> {

  /** The newest log row of an action for a submission (who stopped it and why). */
  Optional<ExtractionControlLog> findFirstByActionAndSubmissionIdOrderByIdDesc(
      String action, Long submissionId);

  /** The ten latest control events, newest first. */
  List<ExtractionControlLog> findTop10ByOrderByIdDesc();
}
