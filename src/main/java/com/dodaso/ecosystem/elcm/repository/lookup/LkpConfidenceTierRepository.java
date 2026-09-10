package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpConfidenceTier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpConfidenceTierRepository extends JpaRepository<LkpConfidenceTier, Long> {

    Optional<LkpConfidenceTier> findByCode(String code);
}
