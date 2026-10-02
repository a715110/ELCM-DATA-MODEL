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
 *
 * ADDED 2026-09-29 -- newRecordName/newRecordCounterparty/
 * newRecordPropertyAddress/existingRecordQuery: see the matching entity
 * fields' Javadoc. Only the fields matching routingIntentDTO's code are ever
 * populated by a caller (UploadFilesService.submitToPipeline() on the
 * elcm-ui side).
 *
 * REVISED 2026-10-01 -- newRecordAddressLine2/City/State/Zip added
 * alongside the entity's same new columns. existingRecordId added: the id
 * of the ContractRecord the user actually picked from the Existing Record
 * autocomplete (see ContractRecordOptionRow) -- required (server-side) when
 * routingIntentDTO's code is EXISTING_RECORD, since
 * StageDocumentService.createStagedDocuments() needs a real id to look up,
 * not the free-text existingRecordQuery.
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
  private String newRecordName;
  private String newRecordCounterparty;
  private String newRecordPropertyAddress;
  private String newRecordAddressLine2;
  private String newRecordCity;
  private String newRecordState;
  private String newRecordZip;
  private String existingRecordQuery;
  private Long existingRecordId;
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