package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpPackageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpPackageStatusRepository extends JpaRepository<LkpPackageStatus, Long> {

    Optional<LkpPackageStatus> findByCode(String code);
}
