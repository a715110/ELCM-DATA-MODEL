package com.dodaso.ecosystem.elcm.repository.reassessment;

import com.dodaso.ecosystem.elcm.entity.reassessment.ReassessmentSurveyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReassessmentSurveyTemplateRepository extends JpaRepository<ReassessmentSurveyTemplate, Long> {

    Optional<ReassessmentSurveyTemplate> findByCode(String code);

    List<ReassessmentSurveyTemplate> findByIsActiveTrueOrderBySortOrderAscNameAsc();

    /** ADDED 2026-11-13. Every template, published or not, for the survey builder. */
    List<ReassessmentSurveyTemplate> findAllByOrderBySortOrderAscNameAsc();
}
