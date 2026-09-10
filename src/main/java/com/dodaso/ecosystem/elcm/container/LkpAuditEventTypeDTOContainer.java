package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpAuditEventTypeDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpAuditEventTypeDTO. Carries a single LkpAuditEventTypeDTO for single-record
 * create/read/update/delete operations, and a LkpAuditEventTypeDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpAuditEventTypeDTOContainer extends DataContainer<LkpAuditEventTypeDTO> {

  LkpAuditEventTypeDTO lkpAuditEventTypeDTO;
  List<LkpAuditEventTypeDTO> lkpAuditEventTypeDTOList;
}
