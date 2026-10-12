package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionTemplateField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionTemplateFieldRepository extends JpaRepository<ExtractionTemplateField, Long> {

    List<ExtractionTemplateField> findByTemplate_IdOrderByDisplayOrder(Long templateId);
}
