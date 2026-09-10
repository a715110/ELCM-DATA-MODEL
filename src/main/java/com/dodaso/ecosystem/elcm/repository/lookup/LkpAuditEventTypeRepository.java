package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpAuditEventType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpAuditEventTypeRepository extends JpaRepository<LkpAuditEventType, Long> {

    Optional<LkpAuditEventType> findByCode(String code);
}
