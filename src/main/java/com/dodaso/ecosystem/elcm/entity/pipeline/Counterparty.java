package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
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
 * Maps to elcm.counterparty -- generated from the authoritative
 * dodaso-platform.dbs schema (elcm.sql export), not hand-written. Same
 * conventions as every other entity in this package: unidirectional
 * (owning-side-only) relationships, FetchType.LAZY on every @ManyToOne, and
 * created_at/updated_at left insertable=false/updatable=false since the
 * database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those values.
 *
 * ADDED 2026-10-01 -- standalone, reusable table (not a column on
 * ContractRecord) per explicit decision in chat: the same counterparty
 * (tenant/landlord/vendor) can be party to more than one lease record over
 * time, so this needs to be its own row a contract_record can reference,
 * not a copy-pasted string on every record. See ContractRecord's own
 * Javadoc for the counterparty_id FK this backs.
 *
 * REVISED 2026-10-01: find-by-name-or-create against this table now
 * happens synchronously at "Add to Pipeline" time, in
 * RecordProvisioningService.createNewRecord() -- not a later "Promote to
 * Record" step. staged_document.new_record_counterparty (see
 * StagedDocument's Javadoc) is kept only as an audit-trail copy of the raw
 * text once a real Counterparty row exists.
 *
 * name is the only business field for now -- deliberately minimal (no
 * contact info, tax id, counterparty type, etc.) until a real requirement
 * for those shows up; add columns here (and to the DDL) only when one does,
 * rather than guessing at a fuller shape upfront.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "counterparty")
@Getter
@Setter
public class Counterparty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

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
