package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.AddressDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for AddressDTO. Carries a single AddressDTO for single-record
 * create/read/update/delete operations, and a AddressDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AddressDTOContainer extends DataContainer<AddressDTO> {

  AddressDTO addressDTO;
  List<AddressDTO> addressDTOList;
}
