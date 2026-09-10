package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpContractRecordStatusDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpContractRecordStatusDTO. Carries a single LkpContractRecordStatusDTO for single-record
 * create/read/update/delete operations, and a LkpContractRecordStatusDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpContractRecordStatusDTOContainer extends DataContainer<LkpContractRecordStatusDTO> {

  LkpContractRecordStatusDTO lkpContractRecordStatusDTO;
  List<LkpContractRecordStatusDTO> lkpContractRecordStatusDTOList;
}
