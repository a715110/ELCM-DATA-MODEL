package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ContractPackageDTO;
import com.dodaso.ecosystem.elcm.dto.LkpApprovalDecisionDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ApprovalDecision entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ApprovalDecisionDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class ApprovalDecisionDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private ContractPackageDTO contractPackageDTO;
  private String approvalRole;
  private LkpApprovalDecisionDTO decisionDTO;
  private String reasonCodes;
  private String decidedBy;
  private LocalDateTime decidedAt;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
