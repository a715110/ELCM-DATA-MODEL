package com.dodaso.ecosystem.elcm.repository.criticaldate;

import com.dodaso.ecosystem.elcm.entity.criticaldate.CriticalDateTask;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/** ADDED 2026-11-16 -- the critical date tasks requested so far (see CriticalDateTask). */
public interface CriticalDateTaskRepository extends JpaRepository<CriticalDateTask, Long> {

  /** The tasks of one record in one status, oldest first. */
  List<CriticalDateTask> findByContractRecord_IdAndStatusOrderByIdAsc(Long contractRecordId,
      String status);

  /** The records that have an open critical date task, so the job can check them again. */
  @Query("select distinct t.contractRecord.id from CriticalDateTask t where t.status = 'OPEN'")
  List<Long> findRecordIdsWithOpenTasks();

  /** Every task in one status (the Critical Dates screen reads the OPEN ones). */
  List<CriticalDateTask> findByStatus(String status);
}
