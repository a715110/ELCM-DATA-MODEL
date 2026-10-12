package com.dodaso.ecosystem.elcm.entity.extraction;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.extraction_field_revision (ADDED 2026-10-12): one row per change a reviewer makes
 * to a field result (a corrected value, a confirmation, a confirm-all). Append only: rows are
 * never updated or deleted. extraction_field_result keeps the current state; this table keeps
 * the history. previous_value and new_value are the effective values, that is the corrected value
 * when there is one, otherwise the extracted value.
 */
@Entity
@Table(name = "extraction_field_revision",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"field_result_id", "revision_no"})})
@Getter
@Setter
public class ExtractionFieldRevision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_result_id", nullable = false)
    private ExtractionFieldResult fieldResult;

    @Column(name = "revision_no", nullable = false)
    private Integer revisionNo;

    @Column(name = "previous_value", length = 2000)
    private String previousValue;

    @Column(name = "new_value", length = 2000)
    private String newValue;

    @Column(name = "confirmed_flag", nullable = false)
    private Boolean confirmedFlag = false;

    /** CORRECTED, CONFIRMED, UNCONFIRMED or CONFIRM_ALL. */
    @Column(name = "action", nullable = false, length = 20)
    private String action;

    @Column(name = "changed_by", length = 255)
    private String changedBy;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;

    @Column(name = "reason", length = 500)
    private String reason;
}
