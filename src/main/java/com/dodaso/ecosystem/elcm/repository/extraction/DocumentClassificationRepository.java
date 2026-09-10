package com.dodaso.ecosystem.elcm.repository.extraction;

import com.dodaso.ecosystem.elcm.entity.extraction.DocumentClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentClassificationRepository extends JpaRepository<DocumentClassification, Long> {
}
