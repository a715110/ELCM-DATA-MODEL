package com.dodaso.ecosystem.elcm.entity.reassessment;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpReassessmentCaseStatus;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpReassessmentTriggerType;
import com.dodaso.ecosystem.elcm.entity.pipeline.ContractRecord;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.reassessment_case -- generated from the authoritative dodaso-platform.dbs
 * schema (elcm.sql export), not hand-written. Relationships are
 * unidirectional (owning side only, no inverse @OneToMany collections) to
 * keep this first pass simple -- add inverse collections later only where a
 * real query need shows up for one. All @ManyToOne/@OneToOne use
 * FetchType.LAZY deliberately (JPA defaults @ManyToOne to EAGER, which is
 * usually wrong). created_at/updated_at are insertable=false, updatable=false
 * -- the database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those
 * values, not the application.
 */
@Entity
@Table(name = "reassessment_case")
@Getter
@Setter
public class ReassessmentCase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "case_code", nullable = false, length = 50)
    private String caseCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_record_id", nullable = false)
    private ContractRecord contractRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trigger_type_id", nullable = false)
    private LkpReassessmentTriggerType triggerType;

    @Column(name = "trigger_event_description", length = 1000)
    private String triggerEventDescription;

    @Column(name = "trigger_event_date")
    private LocalDate triggerEventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private LkpReassessmentCaseStatus status;

    @Column(name = "opened_by", nullable = false, length = 255)
    private String openedBy;

    @Column(name = "opened_at", nullable = false)
    private LocalDateTime openedAt;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
