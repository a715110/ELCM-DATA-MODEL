package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ReassessmentCaseDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ReassessmentCaseDTO. Carries a single ReassessmentCaseDTO for single-record
 * create/read/update/delete operations, and a ReassessmentCaseDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ReassessmentCaseDTOContainer extends DataContainer<ReassessmentCaseDTO> {

  ReassessmentCaseDTO reassessmentCaseDTO;
  List<ReassessmentCaseDTO> reassessmentCaseDTOList;
}
