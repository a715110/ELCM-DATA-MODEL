package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionTemplateField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionTemplateFieldRepository extends JpaRepository<ExtractionTemplateField, Long> {

    List<ExtractionTemplateField> findByTemplate_IdOrderByDisplayOrder(Long templateId);

    /** Removes the fields of a draft before they are written again (ADDED 2026-10-14). */
    void deleteByTemplate_Id(Long templateId);
}
