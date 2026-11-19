package com.dodaso.ecosystem.elcm.entity.criticaldate;

import com.dodaso.ecosystem.elcm.entity.pipeline.ContractRecord;
import com.dodaso.ecosystem.elcm.entity.pipeline.ContractTerm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.critical_date_task (ADDED 2026-11-16): the memory of the critical date job. One row
 * says that an ECWS task was requested for one date (one contract_term) under one rule, so the
 * same date never gets a second task. status is OPEN while the task stands and RETIRED when the
 * date was replaced by a later Apply, the notice period changed, or the record left the live
 * statuses. section_key is the value sent to ECWS (ui_section_id, at most 50 characters), so ELCM
 * can close that task later. created_at belongs to the database.
 */
@Entity
@Table(name = "critical_date_task")
@Getter
@Setter
public class CriticalDateTask implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final String OPEN = "OPEN";
  public static final String RETIRED = "RETIRED";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rule_id", nullable = false)
  private CriticalDateRule rule;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contract_record_id", nullable = false)
  private ContractRecord contractRecord;

  /** The term (the date value) this task was made for. */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contract_term_id", nullable = false)
  private ContractTerm contractTerm;

  /** The date the task is due on (the critical date, less any notice days). */
  @Column(name = "due_date", nullable = false)
  private LocalDate dueDate;

  @Column(name = "section_key", nullable = false, length = 50)
  private String sectionKey;

  @Column(name = "status", nullable = false, length = 10)
  private String status = OPEN;

  @Column(name = "retired_at")
  private LocalDateTime retiredAt;

  @Column(name = "retired_reason", length = 200)
  private String retiredReason;

  @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
  private LocalDateTime createdAt;
}
