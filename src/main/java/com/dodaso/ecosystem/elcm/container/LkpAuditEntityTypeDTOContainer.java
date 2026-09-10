package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpAuditEntityTypeDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpAuditEntityTypeDTO. Carries a single LkpAuditEntityTypeDTO for single-record
 * create/read/update/delete operations, and a LkpAuditEntityTypeDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpAuditEntityTypeDTOContainer extends DataContainer<LkpAuditEntityTypeDTO> {

  LkpAuditEntityTypeDTO lkpAuditEntityTypeDTO;
  List<LkpAuditEntityTypeDTO> lkpAuditEntityTypeDTOList;
}
