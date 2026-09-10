package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpSubmissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpSubmissionStatusRepository extends JpaRepository<LkpSubmissionStatus, Long> {

    Optional<LkpSubmissionStatus> findByCode(String code);
}
