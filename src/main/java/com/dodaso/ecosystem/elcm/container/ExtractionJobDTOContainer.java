package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ExtractionJobDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ExtractionJobDTO. Carries a single ExtractionJobDTO for single-record
 * create/read/update/delete operations, and a ExtractionJobDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ExtractionJobDTOContainer extends DataContainer<ExtractionJobDTO> {

  ExtractionJobDTO extractionJobDTO;
  List<ExtractionJobDTO> extractionJobDTOList;
}
