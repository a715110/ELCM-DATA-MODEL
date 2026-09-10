package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpAuditEntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpAuditEntityTypeRepository extends JpaRepository<LkpAuditEntityType, Long> {

    Optional<LkpAuditEntityType> findByCode(String code);
}
