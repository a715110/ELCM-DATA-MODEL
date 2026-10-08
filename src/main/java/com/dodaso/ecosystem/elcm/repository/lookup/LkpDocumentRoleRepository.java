package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpDocumentRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface LkpDocumentRoleRepository extends JpaRepository<LkpDocumentRole, Long> {

    Optional<LkpDocumentRole> findByCode(String code);

    /** Roles offered in the Create Document Set dialog, in display order. */
    @Query("SELECT r FROM LkpDocumentRole r WHERE r.isActive = true ORDER BY r.sortOrder")
    List<LkpDocumentRole> findActiveOrdered();
}
