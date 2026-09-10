package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpContractRecordRelationshipTypeDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpContractRecordRelationshipTypeDTO. Carries a single LkpContractRecordRelationshipTypeDTO for single-record
 * create/read/update/delete operations, and a LkpContractRecordRelationshipTypeDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpContractRecordRelationshipTypeDTOContainer extends DataContainer<LkpContractRecordRelationshipTypeDTO> {

  LkpContractRecordRelationshipTypeDTO lkpContractRecordRelationshipTypeDTO;
  List<LkpContractRecordRelationshipTypeDTO> lkpContractRecordRelationshipTypeDTOList;
}
