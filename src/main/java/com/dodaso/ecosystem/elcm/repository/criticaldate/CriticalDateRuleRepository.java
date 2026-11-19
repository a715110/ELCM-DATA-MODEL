package com.dodaso.ecosystem.elcm.repository.criticaldate;

import com.dodaso.ecosystem.elcm.entity.criticaldate.CriticalDateRule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/** ADDED 2026-11-16 -- the critical date rules (see CriticalDateRule). */
public interface CriticalDateRuleRepository extends JpaRepository<CriticalDateRule, Long> {

  /** The rules the job applies, oldest first. */
  List<CriticalDateRule> findByEnabledTrueOrderByIdAsc();
}
