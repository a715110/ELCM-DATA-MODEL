package com.dodaso.ecosystem.elcm.mapper;

import com.dodaso.ecosystem.elcm.dto.WorkspaceDTO;
import com.dodaso.ecosystem.elcm.entity.pipeline.Workspace;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for the elcm Workspace entity/DTO pair, same
 * INSTANCE-field convention as TaskCommentMapper.
 *
 * No @Mapping overrides needed -- Workspace and WorkspaceDTO declare the
 * exact same field names (id, code, name, businessArea, isActive,
 * createdBy, createdAt, updatedBy, updatedAt), so MapStruct's default
 * name-based matching covers every field on its own. No @Condition/
 * LazyLoadingAwareMapper is needed either, unlike TaskCommentMapper --
 * Workspace has no lazy collection associations (see its own Javadoc:
 * unidirectional, owning-side-only relationships, and this entity has none
 * at all), so there's nothing here that could trip a
 * LazyInitializationException the way TaskCommentReaction could on
 * TaskComment.
 *
 * Used by WorkspaceService.getAllWorkspaces() (WorkspaceMapper.INSTANCE::toDTO).
 */
@Mapper
public interface WorkspaceMapper {

  WorkspaceMapper INSTANCE = Mappers.getMapper(WorkspaceMapper.class);

  WorkspaceDTO toDTO(Workspace entity);

  Workspace toEntity(WorkspaceDTO dto);
}