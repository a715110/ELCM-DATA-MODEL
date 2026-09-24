package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ContractRecordDTO;
import com.dodaso.ecosystem.elcm.dto.LkpContractTypeDTO;
import com.dodaso.ecosystem.elcm.dto.LkpRoutingIntentDTO;
import com.dodaso.ecosystem.elcm.dto.LkpStagedDocumentStatusDTO;
import com.dodaso.ecosystem.elcm.dto.WorkspaceDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm StagedDocument entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching StagedDocumentDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class StagedDocumentDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private Long fileUploadId;
  private WorkspaceDTO workspaceDTO;
  private LkpContractTypeDTO contractTypeDTO;
  private ContractRecordDTO targetRecordDTO;
  private LkpRoutingIntentDTO routingIntentDTO;
  private String assigneeId;
  private LkpStagedDocumentStatusDTO statusDTO;
  private String comments;
  private String uploadedBy;
  private LocalDateTime uploadedAt;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
