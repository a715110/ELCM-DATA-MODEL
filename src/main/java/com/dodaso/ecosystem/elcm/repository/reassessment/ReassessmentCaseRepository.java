package com.dodaso.ecosystem.elcm.repository.reassessment;

import com.dodaso.ecosystem.elcm.entity.reassessment.ReassessmentCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReassessmentCaseRepository extends JpaRepository<ReassessmentCase, Long> {

    List<ReassessmentCase> findAllByOrderByIdDesc();

    List<ReassessmentCase> findByContractRecord_IdOrderByIdDesc(Long contractRecordId);

    long countByContractRecord_Id(Long contractRecordId);

    boolean existsByCaseCode(String caseCode);
}
