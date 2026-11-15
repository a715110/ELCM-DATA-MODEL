package com.dodaso.ecosystem.elcm.repository.reassessment;

import com.dodaso.ecosystem.elcm.entity.reassessment.ReassessmentSurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ReassessmentSurveyResponseRepository extends JpaRepository<ReassessmentSurveyResponse, Long> {

    Optional<ReassessmentSurveyResponse> findFirstByReassessmentCase_IdOrderByIdDesc(Long caseId);

    /** ADDED 2026-11-13. How many times a template has been sent; a sent template cannot be deleted. */
    long countByTemplate_Id(Long templateId);
}
