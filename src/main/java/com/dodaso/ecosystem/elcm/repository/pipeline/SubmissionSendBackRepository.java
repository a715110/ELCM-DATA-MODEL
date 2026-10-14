package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.SubmissionSendBack;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionSendBackRepository extends JpaRepository<SubmissionSendBack, Long> {

  /** The send-backs of one submission, newest first. */
  List<SubmissionSendBack> findBySubmission_IdOrderByIdDesc(Long submissionId);
}
