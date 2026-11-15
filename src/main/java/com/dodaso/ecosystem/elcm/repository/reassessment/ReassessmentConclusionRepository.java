package com.dodaso.ecosystem.elcm.repository.reassessment;

import com.dodaso.ecosystem.elcm.entity.reassessment.ReassessmentConclusion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ReassessmentConclusionRepository extends JpaRepository<ReassessmentConclusion, Long> {

    Optional<ReassessmentConclusion> findByReassessmentCase_Id(Long caseId);
}
