package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpReassessmentCaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpReassessmentCaseStatusRepository extends JpaRepository<LkpReassessmentCaseStatus, Long> {

    Optional<LkpReassessmentCaseStatus> findByCode(String code);
}
