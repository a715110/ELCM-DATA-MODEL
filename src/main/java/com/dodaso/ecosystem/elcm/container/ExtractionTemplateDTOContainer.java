package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ExtractionTemplateDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ExtractionTemplateDTO. Carries a single ExtractionTemplateDTO for single-record
 * create/read/update/delete operations, and a ExtractionTemplateDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ExtractionTemplateDTOContainer extends DataContainer<ExtractionTemplateDTO> {

  ExtractionTemplateDTO extractionTemplateDTO;
  List<ExtractionTemplateDTO> extractionTemplateDTOList;
}
