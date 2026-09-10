package com.dodaso.ecosystem.elcm.repository.audit;

import com.dodaso.ecosystem.elcm.entity.audit.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository extends JpaRepository<AuditEvent, Long> {
}
