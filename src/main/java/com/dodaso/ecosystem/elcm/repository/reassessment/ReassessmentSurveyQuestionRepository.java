package com.dodaso.ecosystem.elcm.repository.reassessment;

import com.dodaso.ecosystem.elcm.entity.reassessment.ReassessmentSurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReassessmentSurveyQuestionRepository extends JpaRepository<ReassessmentSurveyQuestion, Long> {

    List<ReassessmentSurveyQuestion> findByTemplate_IdAndIsActiveTrueOrderBySortOrderAscIdAsc(Long templateId);

    /** ADDED 2026-11-13. All questions of a template, active or not, in screen order. */
    List<ReassessmentSurveyQuestion> findByTemplate_IdOrderBySortOrderAscIdAsc(Long templateId);

    /** ADDED 2026-11-13. Number of questions that would be sent. */
    long countByTemplate_IdAndIsActiveTrue(Long templateId);
}
