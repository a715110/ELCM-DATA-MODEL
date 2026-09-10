package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpFieldDataTypeDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpFieldDataTypeDTO. Carries a single LkpFieldDataTypeDTO for single-record
 * create/read/update/delete operations, and a LkpFieldDataTypeDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpFieldDataTypeDTOContainer extends DataContainer<LkpFieldDataTypeDTO> {

  LkpFieldDataTypeDTO lkpFieldDataTypeDTO;
  List<LkpFieldDataTypeDTO> lkpFieldDataTypeDTOList;
}
