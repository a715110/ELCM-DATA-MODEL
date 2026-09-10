package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.PropertyDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for PropertyDTO. Carries a single PropertyDTO for single-record
 * create/read/update/delete operations, and a PropertyDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyDTOContainer extends DataContainer<PropertyDTO> {

  PropertyDTO propertyDTO;
  List<PropertyDTO> propertyDTOList;
}
