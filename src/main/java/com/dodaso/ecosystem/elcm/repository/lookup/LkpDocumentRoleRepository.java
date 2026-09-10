package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpDocumentRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpDocumentRoleRepository extends JpaRepository<LkpDocumentRole, Long> {

    Optional<LkpDocumentRole> findByCode(String code);
}
