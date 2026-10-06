package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractRecordStatus;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractType;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Maps to elcm.contract_record -- generated from the authoritative dodaso-platform.dbs
 * schema (elcm.sql export), not hand-written. Relationships are
 * unidirectional (owning side only, no inverse @OneToMany collections) to
 * keep this first pass simple -- add inverse collections later only where a
 * real query need shows up for one. All @ManyToOne/@OneToOne use
 * FetchType.LAZY deliberately (JPA defaults @ManyToOne to EAGER, which is
 * usually wrong). created_at/updated_at are insertable=false, updatable=false
 * -- the database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those
 * values, not the application.
 *
 * ADDED 2026-10-01 -- counterparty: previously there was no counterparty
 * concept anywhere in the schema at all, even though the Upload Files
 * dialog's New Record sub-panel has collected a Counterparty field from day
 * one (see StagedDocument.newRecordCounterparty) -- that data had nowhere
 * to permanently land once a staged submission is promoted into a real
 * record. Modeled as its own table (elcm.counterparty, see that entity's
 * Javadoc) rather than a plain varchar column here, since the same
 * counterparty can be party to more than one lease record over time.
 * Nullable for now, matching staged_document.target_record_id's own
 * nullable precedent -- existing/legacy contract_record rows predate this
 * column and a real "Promote to Record" workflow to populate it on new ones
 * doesn't exist yet either (see Counterparty's Javadoc).
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "contract_record")
@Getter
@Setter
public class ContractRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "record_code", nullable = false, length = 50)
    private String recordCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_type_id", nullable = false)
    private LkpContractType contractType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_id", nullable = true)
    private Counterparty counterparty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private LkpContractRecordStatus status;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 255)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
