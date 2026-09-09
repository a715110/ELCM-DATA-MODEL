package com.dodaso.ecosystem.elcm.entity.extraction;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpContractType;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpDocumentRole;
import com.dodaso.ecosystem.elcm.entity.pipeline.StagedDocument;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.document_classification -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "document_classification")
@Getter
@Setter
public class DocumentClassification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staged_document_id", nullable = false)
    private StagedDocument stagedDocument;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detected_contract_type_id", nullable = true)
    private LkpContractType detectedContractType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detected_document_role_id", nullable = true)
    private LkpDocumentRole detectedDocumentRole;

    @Column(name = "confidence_pct")
    private BigDecimal confidencePct;

    @Column(name = "confirmed_by", length = 255)
    private String confirmedBy;

    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
