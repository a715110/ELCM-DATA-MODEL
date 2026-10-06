package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractType;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpRoutingIntent;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpStagedDocumentStatus;
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
 * Maps to elcm.staged_document -- generated from the authoritative dodaso-platform.dbs
 * schema (elcm.sql export), not hand-written. Relationships are
 * unidirectional (owning side only, no inverse @OneToMany collections) to
 * keep this first pass simple -- add inverse collections later only where a
 * real query need shows up for one. All @ManyToOne/@OneToOne use
 * FetchType.LAZY deliberately (JPA defaults @ManyToOne to EAGER, which is
 * usually wrong). created_at/updated_at are insertable=false, updatable=false
 * -- the database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those
 * values, not the application.
 *
 * ADDED 2026-09-29 -- newRecordName/newRecordCounterparty/
 * newRecordPropertyAddress/existingRecordQuery: capture the Upload Files
 * dialog's New Record / Existing Record destination sub-panel input
 * directly on this row. See staged_document_new_columns.sql for the
 * original DDL. All nullable -- only the fields matching the row's
 * routingIntent are ever populated (see
 * StageDocumentService.createStagedDocuments()).
 *
 * REVISED 2026-10-01 -- these are no longer deferred to a later "Preparer
 * promotes this to a real record" pass: createStagedDocuments() now creates
 * (NEW_RECORD) or looks up (EXISTING_RECORD) the real ContractRecord/
 * Property/Address/Counterparty rows synchronously, in the same transaction
 * as "Add to Pipeline" itself, and sets targetRecord immediately -- see
 * RecordProvisioningService. These columns are kept anyway as a durable
 * record of exactly what the user originally typed (useful audit trail /
 * fallback display even after the real record exists -- see
 * StageDocumentService.deriveRecordLabel()), not as the only copy of the
 * data anymore. newRecordPropertyAddress specifically is address line 1;
 * newRecordAddressLine2/City/State/Zip (added this revision, see
 * counterparty_table.sql's companion staged_document_address_columns.sql)
 * hold the rest of what a real elcm.address row needs. existingRecordQuery
 * is still just the free-text search string the user typed -- the actual
 * record they picked from the autocomplete is resolved immediately via
 * StagedDocumentDTO.existingRecordId and is never itself persisted here
 * (targetRecord_id already captures the result).
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "staged_document")
@Getter
@Setter
public class StagedDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_upload_id", nullable = false)
    private Long fileUploadId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_type_id", nullable = false)
    private LkpContractType contractType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_record_id", nullable = true)
    private ContractRecord targetRecord;

    @Column(name = "new_record_name", length = 255)
    private String newRecordName;

    @Column(name = "new_record_counterparty", length = 255)
    private String newRecordCounterparty;

    @Column(name = "new_record_property_address", length = 500)
    private String newRecordPropertyAddress;

    /**
     * ADDED 2026-10-01 -- new_record_address_line2/city/state/zip: the
     * dialog's New Record sub-panel originally had one free-text "Property
     * Address" field (above, now semantically address line 1); it now has
     * separate City/State/Zip fields too so a real elcm.address row (which
     * has those as distinct columns) can actually be populated at "Add to
     * Pipeline" time -- see RecordProvisioningService.createNewRecord().
     * All nullable/optional, same as the original property-address field.
     */
    @Column(name = "new_record_address_line2", length = 255)
    private String newRecordAddressLine2;

    @Column(name = "new_record_city", length = 150)
    private String newRecordCity;

    @Column(name = "new_record_state", length = 100)
    private String newRecordState;

    @Column(name = "new_record_zip", length = 20)
    private String newRecordZip;

    @Column(name = "existing_record_query", length = 255)
    private String existingRecordQuery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routing_intent_id", nullable = false)
    private LkpRoutingIntent routingIntent;

    @Column(name = "assignee_id", length = 255)
    private String assigneeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private LkpStagedDocumentStatus status;

    @Column(name = "comments", length = 2000)
    private String comments;

    @Column(name = "uploaded_by", nullable = false, length = 255)
    private String uploadedBy;

    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;

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