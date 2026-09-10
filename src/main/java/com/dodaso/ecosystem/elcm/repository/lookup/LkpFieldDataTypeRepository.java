package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpFieldDataType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpFieldDataTypeRepository extends JpaRepository<LkpFieldDataType, Long> {

    Optional<LkpFieldDataType> findByCode(String code);
}
