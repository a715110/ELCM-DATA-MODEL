package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.PackageDocumentDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for PackageDocumentDTO. Carries a single PackageDocumentDTO for single-record
 * create/read/update/delete operations, and a PackageDocumentDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PackageDocumentDTOContainer extends DataContainer<PackageDocumentDTO> {

  PackageDocumentDTO packageDocumentDTO;
  List<PackageDocumentDTO> packageDocumentDTOList;
}
