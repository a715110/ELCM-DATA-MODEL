package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpContractTypeRepository extends JpaRepository<LkpContractType, Long> {

    Optional<LkpContractType> findByCode(String code);
}
