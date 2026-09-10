package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.StagedDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagedDocumentRepository extends JpaRepository<StagedDocument, Long> {

    long countByStatus_Code(String code);
}
