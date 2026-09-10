package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.SubmissionDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for SubmissionDTO. Carries a single SubmissionDTO for single-record
 * create/read/update/delete operations, and a SubmissionDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubmissionDTOContainer extends DataContainer<SubmissionDTO> {

  SubmissionDTO submissionDTO;
  List<SubmissionDTO> submissionDTOList;
}
