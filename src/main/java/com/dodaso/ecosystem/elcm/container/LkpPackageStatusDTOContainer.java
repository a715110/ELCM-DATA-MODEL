package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpPackageStatusDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpPackageStatusDTO. Carries a single LkpPackageStatusDTO for single-record
 * create/read/update/delete operations, and a LkpPackageStatusDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpPackageStatusDTOContainer extends DataContainer<LkpPackageStatusDTO> {

  LkpPackageStatusDTO lkpPackageStatusDTO;
  List<LkpPackageStatusDTO> lkpPackageStatusDTOList;
}
