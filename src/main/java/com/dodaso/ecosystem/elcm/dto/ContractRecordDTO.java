package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.CounterpartyDTO;
import com.dodaso.ecosystem.elcm.dto.LkpContractRecordStatusDTO;
import com.dodaso.ecosystem.elcm.dto.LkpContractTypeDTO;
import com.dodaso.ecosystem.elcm.dto.PropertyDTO;
import com.dodaso.ecosystem.elcm.dto.WorkspaceDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ContractRecord entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ContractRecordDTOContainer
 * before being passed to/from the service layer.
 *
 * REVISED 2026-10-01: added counterpartyDTO (mirrors the entity's own
 * counterparty_id FK, added same day) and propertyDTO (not a real FK on
 * contract_record -- property has its own contract_record_id FK the other
 * way -- but convenient to carry here anyway so a single ContractRecordDTO
 * is enough to back the Stage Documents dashboard's new file-preview
 * "record details" panel without a second round trip). Both are populated
 * only by RecordProvisioningService.getRecordDetail() (the new get-by-id
 * endpoint) -- every other existing caller of this DTO (e.g. the Existing
 * Record autocomplete's ContractRecordOptionRow, which is a separate,
 * lighter-weight type) is unaffected.
 */
@Getter
@Setter
public class ContractRecordDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private String recordCode;
  private LkpContractTypeDTO contractTypeDTO;
  private WorkspaceDTO workspaceDTO;
  private CounterpartyDTO counterpartyDTO;
  private PropertyDTO propertyDTO;
  private LkpContractRecordStatusDTO statusDTO;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
