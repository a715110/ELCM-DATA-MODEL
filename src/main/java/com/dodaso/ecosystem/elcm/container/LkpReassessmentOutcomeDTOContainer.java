package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpReassessmentOutcomeDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpReassessmentOutcomeDTO. Carries a single LkpReassessmentOutcomeDTO for single-record
 * create/read/update/delete operations, and a LkpReassessmentOutcomeDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpReassessmentOutcomeDTOContainer extends DataContainer<LkpReassessmentOutcomeDTO> {

  LkpReassessmentOutcomeDTO lkpReassessmentOutcomeDTO;
  List<LkpReassessmentOutcomeDTO> lkpReassessmentOutcomeDTOList;
}
