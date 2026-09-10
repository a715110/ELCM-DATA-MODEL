package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpStagedDocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpStagedDocumentStatusRepository extends JpaRepository<LkpStagedDocumentStatus, Long> {

    Optional<LkpStagedDocumentStatus> findByCode(String code);
}
