package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.LkpDocumentRoleDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpDocumentRoleDTO. Carries a single LkpDocumentRoleDTO for single-record
 * create/read/update/delete operations, and a LkpDocumentRoleDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpDocumentRoleDTOContainer extends DataContainer<LkpDocumentRoleDTO> {

  LkpDocumentRoleDTO lkpDocumentRoleDTO;
  List<LkpDocumentRoleDTO> lkpDocumentRoleDTOList;
}
