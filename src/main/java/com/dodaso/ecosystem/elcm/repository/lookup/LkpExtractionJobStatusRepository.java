package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpExtractionJobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpExtractionJobStatusRepository extends JpaRepository<LkpExtractionJobStatus, Long> {

    Optional<LkpExtractionJobStatus> findByCode(String code);
}
