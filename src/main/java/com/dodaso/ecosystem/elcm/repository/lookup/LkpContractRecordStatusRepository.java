package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractRecordStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpContractRecordStatusRepository extends JpaRepository<LkpContractRecordStatus, Long> {

    Optional<LkpContractRecordStatus> findByCode(String code);
}
