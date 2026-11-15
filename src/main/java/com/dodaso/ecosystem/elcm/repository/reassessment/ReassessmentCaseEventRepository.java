package com.dodaso.ecosystem.elcm.repository.reassessment;

import com.dodaso.ecosystem.elcm.entity.reassessment.ReassessmentCaseEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReassessmentCaseEventRepository extends JpaRepository<ReassessmentCaseEvent, Long> {

    List<ReassessmentCaseEvent> findByReassessmentCase_IdOrderByOccurredAtDescIdDesc(Long caseId);
}
