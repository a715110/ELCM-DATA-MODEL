package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.contract_term (ADDED 2026-10-12): one reviewed value of a contract record, for
 * example its commencement date or base rent. The set of terms is not fixed in the schema: a new
 * extraction template field simply produces a new field_key. The value is kept as text and in the
 * typed column that matches data_type, so it can be queried and reported on. Rows are never
 * updated except to set superseded_at: when a later Apply brings a different value for the same
 * field_key, the old row is superseded and a new one is added, so the terms keep their history.
 * The current terms of a record are the rows where superseded_at is null.
 */
@Entity
@Table(name = "contract_term")
@Getter
@Setter
public class ContractTerm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_record_id", nullable = false)
    private ContractRecord contractRecord;

    @Column(name = "field_key", nullable = false, length = 100)
    private String fieldKey;

    @Column(name = "label", nullable = false, length = 150)
    private String label;

    /** STRING, NUMBER, DATE or BOOLEAN (lkp_field_data_type code). */
    @Column(name = "data_type", nullable = false, length = 20)
    private String dataType;

    @Column(name = "value_text", length = 2000)
    private String valueText;

    @Column(name = "value_number", precision = 19, scale = 4)
    private BigDecimal valueNumber;

    @Column(name = "value_date")
    private LocalDate valueDate;

    @Column(name = "value_boolean")
    private Boolean valueBoolean;

    @Column(name = "source_submission_id")
    private Long sourceSubmissionId;

    @Column(name = "source_field_result_id")
    private Long sourceFieldResultId;

    /** Highest extraction_field_revision number of the field result when applied; 0 when the reviewer never touched it. */
    @Column(name = "source_revision_no")
    private Integer sourceRevisionNo;

    @Column(name = "applied_by", length = 255)
    private String appliedBy;

    @Column(name = "applied_at", nullable = false)
    private LocalDateTime appliedAt;

    @Column(name = "superseded_at")
    private LocalDateTime supersededAt;
}
