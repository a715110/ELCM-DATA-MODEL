package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ExtractionTemplateDTO;
import com.dodaso.ecosystem.elcm.dto.LkpExtractionJobStatusDTO;
import com.dodaso.ecosystem.elcm.dto.StagedDocumentDTO;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ExtractionJob entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ExtractionJobDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class ExtractionJobDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private StagedDocumentDTO stagedDocumentDTO;
  private ExtractionTemplateDTO templateDTO;
  private LkpExtractionJobStatusDTO statusDTO;
  private BigDecimal ocrConfidencePct;
  private String agent;
  private LocalDateTime startedAt;
  private LocalDateTime completedAt;
  private Integer durationSeconds;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
