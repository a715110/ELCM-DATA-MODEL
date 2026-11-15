package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.ContractRecordRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRecordRelationshipRepository extends JpaRepository<ContractRecordRelationship, Long> {

    /** ADDED 2026-11-11: the records that replaced this one (reassessment history). */
    java.util.List<ContractRecordRelationship> findByPredecessorRecord_Id(Long predecessorRecordId);
}
