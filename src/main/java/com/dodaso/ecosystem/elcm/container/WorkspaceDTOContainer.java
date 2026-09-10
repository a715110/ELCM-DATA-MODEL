package com.dodaso.ecosystem.elcm.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.WorkspaceDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for WorkspaceDTO. Carries a single WorkspaceDTO for single-record
 * create/read/update/delete operations, and a WorkspaceDTO list for list/search
 * operations, following the ecws-data-model container convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class WorkspaceDTOContainer extends DataContainer<WorkspaceDTO> {

  WorkspaceDTO workspaceDTO;
  List<WorkspaceDTO> workspaceDTOList;
}
