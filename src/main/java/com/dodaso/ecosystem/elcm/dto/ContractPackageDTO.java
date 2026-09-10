package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ContractRecordDTO;
import com.dodaso.ecosystem.elcm.dto.LkpPackageStatusDTO;
import com.dodaso.ecosystem.elcm.dto.WorkspaceDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ContractPackage entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ContractPackageDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class ContractPackageDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private String packageCode;
  private WorkspaceDTO workspaceDTO;
  private ContractRecordDTO targetRecordDTO;
  private LkpPackageStatusDTO statusDTO;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
