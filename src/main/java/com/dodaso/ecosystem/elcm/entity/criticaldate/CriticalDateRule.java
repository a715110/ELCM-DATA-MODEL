package com.dodaso.ecosystem.elcm.entity.criticaldate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.critical_date_rule (ADDED 2026-11-16): one kind of critical date. The rule names a
 * contract term (field_key, a DATE) and says how many days before the date the ECWS task is
 * created. When notice_field_key is set, it names a NUMBER term holding a notice period in days,
 * and the date the task is due on moves that many days earlier, for example the renewal deadline
 * is the expiration date minus the notice days. A new kind of date is a new row, not new code.
 * created_at and updated_at belong to the database.
 */
@Entity
@Table(name = "critical_date_rule")
@Getter
@Setter
public class CriticalDateRule implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /** Short stable name, such as EXPIRATION. */
  @Column(name = "code", nullable = false, length = 40)
  private String code;

  /** Words used in the task summary, such as "Lease expiration". */
  @Column(name = "label", nullable = false, length = 100)
  private String label;

  /** The contract_term.field_key holding the DATE. */
  @Column(name = "field_key", nullable = false, length = 100)
  private String fieldKey;

  /** Optional contract_term.field_key of a NUMBER (days) taken off the date. */
  @Column(name = "notice_field_key", length = 100)
  private String noticeFieldKey;

  /** The task is created this many days before it is due. */
  @Column(name = "lead_days", nullable = false)
  private int leadDays;

  /** ECWS priority of the task: Low, Medium or High. */
  @Column(name = "priority", nullable = false, length = 10)
  private String priority;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  /** ADDED 2026-11-21: login of the administrator who last changed the rule on the admin screen. */
  @Column(name = "updated_by", length = 255)
  private String updatedBy;

  @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
  private LocalDateTime updatedAt;
}
