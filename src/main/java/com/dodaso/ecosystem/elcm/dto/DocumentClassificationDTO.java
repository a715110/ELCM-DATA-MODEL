package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.LkpContractTypeDTO;
import com.dodaso.ecosystem.elcm.dto.LkpDocumentRoleDTO;
import com.dodaso.ecosystem.elcm.dto.StagedDocumentDTO;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm DocumentClassification entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching DocumentClassificationDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class DocumentClassificationDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private StagedDocumentDTO stagedDocumentDTO;
  private LkpContractTypeDTO detectedContractTypeDTO;
  private LkpDocumentRoleDTO detectedDocumentRoleDTO;
  private BigDecimal confidencePct;
  private String confirmedBy;
  private LocalDateTime confirmedAt;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
