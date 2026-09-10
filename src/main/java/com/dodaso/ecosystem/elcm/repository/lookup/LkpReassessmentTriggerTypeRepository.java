package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpReassessmentTriggerType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpReassessmentTriggerTypeRepository extends JpaRepository<LkpReassessmentTriggerType, Long> {

    Optional<LkpReassessmentTriggerType> findByCode(String code);
}
