package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ExtractionFieldResultDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ExtractionFieldResultDTO. Carries a single ExtractionFieldResultDTO for single-record
 * create/read/update/delete operations, and a ExtractionFieldResultDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ExtractionFieldResultDTOContainer extends DataContainer<ExtractionFieldResultDTO> {

  ExtractionFieldResultDTO extractionFieldResultDTO;
  List<ExtractionFieldResultDTO> extractionFieldResultDTOList;
}
