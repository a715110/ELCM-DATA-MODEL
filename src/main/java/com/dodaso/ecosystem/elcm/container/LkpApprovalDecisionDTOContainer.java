package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpApprovalDecisionDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpApprovalDecisionDTO. Carries a single LkpApprovalDecisionDTO for single-record
 * create/read/update/delete operations, and a LkpApprovalDecisionDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpApprovalDecisionDTOContainer extends DataContainer<LkpApprovalDecisionDTO> {

  LkpApprovalDecisionDTO lkpApprovalDecisionDTO;
  List<LkpApprovalDecisionDTO> lkpApprovalDecisionDTOList;
}
