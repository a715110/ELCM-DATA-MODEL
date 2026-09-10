package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ExtractionJobDTO;
import com.dodaso.ecosystem.elcm.dto.ExtractionTemplateFieldDTO;
import com.dodaso.ecosystem.elcm.dto.LkpConfidenceTierDTO;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ExtractionFieldResult entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ExtractionFieldResultDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class ExtractionFieldResultDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private ExtractionJobDTO jobDTO;
  private ExtractionTemplateFieldDTO templateFieldDTO;
  private String extractedValue;
  private BigDecimal confidenceScore;
  private LkpConfidenceTierDTO confidenceTierDTO;
  private Boolean verifiedFlag;
  private String verifiedBy;
  private LocalDateTime verifiedAt;
  private String correctedValue;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
