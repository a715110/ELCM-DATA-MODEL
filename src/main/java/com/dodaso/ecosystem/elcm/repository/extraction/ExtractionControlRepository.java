package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.ExtractionControl;
import org.springframework.data.jpa.repository.JpaRepository;

/** The one-row pause switch of the extraction agent (id 1). */
public interface ExtractionControlRepository extends JpaRepository<ExtractionControl, Long> {}
