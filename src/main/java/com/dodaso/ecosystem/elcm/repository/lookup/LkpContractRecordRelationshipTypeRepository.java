package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractRecordRelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpContractRecordRelationshipTypeRepository extends JpaRepository<LkpContractRecordRelationshipType, Long> {

    Optional<LkpContractRecordRelationshipType> findByCode(String code);
}
