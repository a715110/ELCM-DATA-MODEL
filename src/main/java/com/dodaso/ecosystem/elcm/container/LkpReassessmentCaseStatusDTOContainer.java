package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpReassessmentCaseStatusDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpReassessmentCaseStatusDTO. Carries a single LkpReassessmentCaseStatusDTO for single-record
 * create/read/update/delete operations, and a LkpReassessmentCaseStatusDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpReassessmentCaseStatusDTOContainer extends DataContainer<LkpReassessmentCaseStatusDTO> {

  LkpReassessmentCaseStatusDTO lkpReassessmentCaseStatusDTO;
  List<LkpReassessmentCaseStatusDTO> lkpReassessmentCaseStatusDTOList;
}
