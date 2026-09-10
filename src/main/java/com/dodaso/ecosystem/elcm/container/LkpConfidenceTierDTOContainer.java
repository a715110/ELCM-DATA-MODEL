package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpConfidenceTierDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpConfidenceTierDTO. Carries a single LkpConfidenceTierDTO for single-record
 * create/read/update/delete operations, and a LkpConfidenceTierDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpConfidenceTierDTOContainer extends DataContainer<LkpConfidenceTierDTO> {

  LkpConfidenceTierDTO lkpConfidenceTierDTO;
  List<LkpConfidenceTierDTO> lkpConfidenceTierDTOList;
}
