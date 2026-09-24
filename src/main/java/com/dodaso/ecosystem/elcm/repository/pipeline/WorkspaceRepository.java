package com.dodaso.ecosystem.elcm.repository.pipeline;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodaso.ecosystem.elcm.entity.pipeline.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    Optional<Workspace> findByCode(String code);
}
