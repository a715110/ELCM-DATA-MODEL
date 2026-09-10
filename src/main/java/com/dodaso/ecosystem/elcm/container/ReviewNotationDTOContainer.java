package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.ReviewNotationDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for ReviewNotationDTO. Carries a single ReviewNotationDTO for single-record
 * create/read/update/delete operations, and a ReviewNotationDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ReviewNotationDTOContainer extends DataContainer<ReviewNotationDTO> {

  ReviewNotationDTO reviewNotationDTO;
  List<ReviewNotationDTO> reviewNotationDTOList;
}
