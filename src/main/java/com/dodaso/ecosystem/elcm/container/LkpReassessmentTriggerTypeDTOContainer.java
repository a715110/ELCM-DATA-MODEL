package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpReassessmentTriggerTypeDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpReassessmentTriggerTypeDTO. Carries a single LkpReassessmentTriggerTypeDTO for single-record
 * create/read/update/delete operations, and a LkpReassessmentTriggerTypeDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpReassessmentTriggerTypeDTOContainer extends DataContainer<LkpReassessmentTriggerTypeDTO> {

  LkpReassessmentTriggerTypeDTO lkpReassessmentTriggerTypeDTO;
  List<LkpReassessmentTriggerTypeDTO> lkpReassessmentTriggerTypeDTOList;
}
