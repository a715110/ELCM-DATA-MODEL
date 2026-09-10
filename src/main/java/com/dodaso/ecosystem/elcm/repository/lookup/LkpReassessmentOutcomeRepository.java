package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpReassessmentOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpReassessmentOutcomeRepository extends JpaRepository<LkpReassessmentOutcome, Long> {

    Optional<LkpReassessmentOutcome> findByCode(String code);
}
