package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.DocumentClassificationDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for DocumentClassificationDTO. Carries a single DocumentClassificationDTO for single-record
 * create/read/update/delete operations, and a DocumentClassificationDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DocumentClassificationDTOContainer extends DataContainer<DocumentClassificationDTO> {

  DocumentClassificationDTO documentClassificationDTO;
  List<DocumentClassificationDTO> documentClassificationDTOList;
}
