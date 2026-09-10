package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ContractRecordRelationshipDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ContractRecordRelationshipDTO. Carries a single ContractRecordRelationshipDTO for single-record
 * create/read/update/delete operations, and a ContractRecordRelationshipDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ContractRecordRelationshipDTOContainer extends DataContainer<ContractRecordRelationshipDTO> {

  ContractRecordRelationshipDTO contractRecordRelationshipDTO;
  List<ContractRecordRelationshipDTO> contractRecordRelationshipDTOList;
}
