package com.dodaso.ecosystem.elcm.entity.approval;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpApprovalDecision;
import com.dodaso.ecosystem.elcm.entity.pipeline.ContractPackage;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.approval_decision -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "approval_decision")
@Getter
@Setter
public class ApprovalDecision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private ContractPackage contractPackage;

    @Column(name = "approval_role", nullable = false, length = 50)
    private String approvalRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id", nullable = false)
    private LkpApprovalDecision decision;

    @Column(name = "reason_codes", length = 500)
    private String reasonCodes;

    @Column(name = "decided_by", nullable = false, length = 255)
    private String decidedBy;

    @Column(name = "decided_at", nullable = false)
    private LocalDateTime decidedAt;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
