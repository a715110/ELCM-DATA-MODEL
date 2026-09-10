package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpApprovalDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpApprovalDecisionRepository extends JpaRepository<LkpApprovalDecision, Long> {

    Optional<LkpApprovalDecision> findByCode(String code);
}
