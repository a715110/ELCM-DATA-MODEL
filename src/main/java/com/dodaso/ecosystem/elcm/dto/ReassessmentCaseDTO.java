package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import com.dodaso.ecosystem.elcm.dto.ContractRecordDTO;
import com.dodaso.ecosystem.elcm.dto.LkpReassessmentCaseStatusDTO;
import com.dodaso.ecosystem.elcm.dto.LkpReassessmentTriggerTypeDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm ReassessmentCase entity/table. Mirrors the JPA entity's persisted
 * columns; relationship fields are represented as nested DTOs (suffixed
 * "DTO") rather than the JPA entity types, per the ecws-data-model
 * convention. Instances are placed into the matching ReassessmentCaseDTOContainer
 * before being passed to/from the service layer.
 */
@Getter
@Setter
public class ReassessmentCaseDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private String caseCode;
  private ContractRecordDTO contractRecordDTO;
  private LkpReassessmentTriggerTypeDTO triggerTypeDTO;
  private String triggerEventDescription;
  private LocalDate triggerEventDate;
  private LkpReassessmentCaseStatusDTO statusDTO;
  private String openedBy;
  private LocalDateTime openedAt;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
