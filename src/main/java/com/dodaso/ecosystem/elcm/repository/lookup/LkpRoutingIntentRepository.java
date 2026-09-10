package com.dodaso.ecosystem.elcm.repository.lookup;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpRoutingIntent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LkpRoutingIntentRepository extends JpaRepository<LkpRoutingIntent, Long> {

    Optional<LkpRoutingIntent> findByCode(String code);
}
