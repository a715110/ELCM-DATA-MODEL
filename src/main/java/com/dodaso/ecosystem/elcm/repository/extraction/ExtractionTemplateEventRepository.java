package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionTemplateEvent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionTemplateEventRepository
    extends JpaRepository<ExtractionTemplateEvent, Long> {

  /** The history of one template, newest first. */
  List<ExtractionTemplateEvent> findByTemplateNameOrderByIdDesc(String templateName);
}
