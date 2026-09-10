package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ReassessmentSurveyResponseDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ReassessmentSurveyResponseDTO. Carries a single ReassessmentSurveyResponseDTO for single-record
 * create/read/update/delete operations, and a ReassessmentSurveyResponseDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ReassessmentSurveyResponseDTOContainer extends DataContainer<ReassessmentSurveyResponseDTO> {

  ReassessmentSurveyResponseDTO reassessmentSurveyResponseDTO;
  List<ReassessmentSurveyResponseDTO> reassessmentSurveyResponseDTOList;
}
