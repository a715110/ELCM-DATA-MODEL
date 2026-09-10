package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpExtractionJobStatusDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpExtractionJobStatusDTO. Carries a single LkpExtractionJobStatusDTO for single-record
 * create/read/update/delete operations, and a LkpExtractionJobStatusDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpExtractionJobStatusDTOContainer extends DataContainer<LkpExtractionJobStatusDTO> {

  LkpExtractionJobStatusDTO lkpExtractionJobStatusDTO;
  List<LkpExtractionJobStatusDTO> lkpExtractionJobStatusDTOList;
}
