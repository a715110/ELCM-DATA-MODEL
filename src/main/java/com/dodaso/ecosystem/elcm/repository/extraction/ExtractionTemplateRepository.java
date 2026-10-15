package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionTemplate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionTemplateRepository extends JpaRepository<ExtractionTemplate, Long> {

    /** The newest active template for a contract type, or empty when the type has none. */
    Optional<ExtractionTemplate> findFirstByContractType_IdAndIsActiveTrueOrderByIdDesc(Long contractTypeId);

    /** Every version of every template, by name then newest first (ADDED 2026-10-14). */
    List<ExtractionTemplate> findAllByOrderByNameAscIdDesc();

    /** All versions of one template, newest first. */
    List<ExtractionTemplate> findByNameOrderByIdDesc(String name);

    /** The open draft (or the published version) of a template, if there is one. */
    Optional<ExtractionTemplate> findFirstByNameAndStatus(String name, String status);
}
