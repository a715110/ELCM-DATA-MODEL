package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.ContractTerm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractTermRepository extends JpaRepository<ContractTerm, Long> {

    /** The terms in force: rows that no later Apply has superseded. */
    List<ContractTerm> findByContractRecord_IdAndSupersededAtIsNull(Long contractRecordId);

    /** Every value a field of the record ever had, newest first. */
    List<ContractTerm> findByContractRecord_IdAndFieldKeyOrderByAppliedAtDescIdDesc(Long contractRecordId, String fieldKey);
}
