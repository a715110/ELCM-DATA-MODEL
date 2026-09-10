package com.dodaso.ecosystem.elcm.repository.approval;

import com.dodaso.ecosystem.elcm.entity.approval.ApprovalDecision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalDecisionRepository extends JpaRepository<ApprovalDecision, Long> {
}
