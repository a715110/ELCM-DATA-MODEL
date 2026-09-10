package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ApprovalDecisionDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ApprovalDecisionDTO. Carries a single ApprovalDecisionDTO for single-record
 * create/read/update/delete operations, and a ApprovalDecisionDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ApprovalDecisionDTOContainer extends DataContainer<ApprovalDecisionDTO> {

  ApprovalDecisionDTO approvalDecisionDTO;
  List<ApprovalDecisionDTO> approvalDecisionDTOList;
}
