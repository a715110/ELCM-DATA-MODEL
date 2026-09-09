package com.dodaso.ecosystem.elcm.entity.reassessment;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpApprovalDecision;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpReassessmentOutcome;
import com.dodaso.ecosystem.elcm.entity.pipeline.ContractRecordRelationship;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.reassessment_conclusion -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "reassessment_conclusion")
@Getter
@Setter
public class ReassessmentConclusion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reassessment_case_id", nullable = false)
    private ReassessmentCase reassessmentCase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outcome_id", nullable = false)
    private LkpReassessmentOutcome outcome;

    @Column(name = "conclusion_summary", length = 2000)
    private String conclusionSummary;

    @Column(name = "concluded_by", nullable = false, length = 255)
    private String concludedBy;

    @Column(name = "concluded_at", nullable = false)
    private LocalDateTime concludedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_decision_id", nullable = true)
    private LkpApprovalDecision approvalDecision;

    @Column(name = "approved_by", length = 255)
    private String approvedBy;

    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resulting_relationship_id", nullable = true)
    private ContractRecordRelationship resultingRelationship;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
