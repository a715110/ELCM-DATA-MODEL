package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.StagedDocumentDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for StagedDocumentDTO. Carries a single StagedDocumentDTO for single-record
 * create/read/update/delete operations, and a StagedDocumentDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StagedDocumentDTOContainer extends DataContainer<StagedDocumentDTO> {

  StagedDocumentDTO stagedDocumentDTO;
  List<StagedDocumentDTO> stagedDocumentDTOList;
}
