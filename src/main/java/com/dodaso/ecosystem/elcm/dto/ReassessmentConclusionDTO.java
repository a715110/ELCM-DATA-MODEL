package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ContractRecordRelationshipDTO;
import com.dodaso.ecosystem.elcm.dto.LkpApprovalDecisionDTO;
import com.dodaso.ecosystem.elcm.dto.LkpReassessmentOutcomeDTO;
import com.dodaso.ecosystem.elcm.dto.ReassessmentCaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ReassessmentConclusion entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ReassessmentConclusionDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class ReassessmentConclusionDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private ReassessmentCaseDTO reassessmentCaseDTO;
  private LkpReassessmentOutcomeDTO outcomeDTO;
  private String conclusionSummary;
  private String concludedBy;
  private LocalDateTime concludedAt;
  private LkpApprovalDecisionDTO approvalDecisionDTO;
  private String approvedBy;
  private LocalDateTime approvedAt;
  private ContractRecordRelationshipDTO resultingRelationshipDTO;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
