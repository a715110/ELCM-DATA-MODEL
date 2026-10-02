package com.dodaso.ecosystem.elcm.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the elcm Counterparty entity/table. Mirrors the JPA entity's
 * persisted columns, same convention as every other DTO in this package.
 *
 * ADDED 2026-10-01 -- alongside ContractRecordDTO.counterpartyDTO, to back
 * the Stage Documents dashboard's new file-preview "record details" panel
 * (see ContractRecordController's get-by-id endpoint).
 */
@Getter
@Setter
public class CounterpartyDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
