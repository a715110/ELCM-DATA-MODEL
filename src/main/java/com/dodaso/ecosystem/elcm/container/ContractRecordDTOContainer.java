package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ContractRecordDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ContractRecordDTO. Carries a single ContractRecordDTO for single-record
 * create/read/update/delete operations, and a ContractRecordDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ContractRecordDTOContainer extends DataContainer<ContractRecordDTO> {

  ContractRecordDTO contractRecordDTO;
  List<ContractRecordDTO> contractRecordDTOList;
}
