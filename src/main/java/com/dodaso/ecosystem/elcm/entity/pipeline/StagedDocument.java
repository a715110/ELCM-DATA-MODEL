package com.dodaso.ecosystem.elcm.entity.pipeline;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractType;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpRoutingIntent;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpStagedDocumentStatus;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

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
 */
@Entity
@Table(name = "staged_document")
@Getter
@Setter
public class StagedDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "blob_uri", nullable = false, length = 1000)
    private String blobUri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_type_id", nullable = false)
    private LkpContractType contractType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_record_id", nullable = true)
    private ContractRecord targetRecord;

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

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
