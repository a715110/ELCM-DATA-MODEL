package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionTemplate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionTemplateRepository extends JpaRepository<ExtractionTemplate, Long> {

    /** The newest active template for a contract type, or empty when the type has none. */
    Optional<ExtractionTemplate> findFirstByContractType_IdAndIsActiveTrueOrderByIdDesc(Long contractTypeId);
}
