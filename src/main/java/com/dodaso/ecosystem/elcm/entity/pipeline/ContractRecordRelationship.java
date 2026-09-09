package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractRecordRelationshipType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.contract_record_relationship -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "contract_record_relationship", uniqueConstraints = {@UniqueConstraint(columnNames = {"predecessor_record_id", "relationship_type_id"})})
@Getter
@Setter
public class ContractRecordRelationship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "successor_record_id", nullable = false)
    private ContractRecord successorRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predecessor_record_id", nullable = false)
    private ContractRecord predecessorRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relationship_type_id", nullable = false)
    private LkpContractRecordRelationshipType relationshipType;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "triggering_package_id", nullable = true)
    private ContractPackage triggeringPackage;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
