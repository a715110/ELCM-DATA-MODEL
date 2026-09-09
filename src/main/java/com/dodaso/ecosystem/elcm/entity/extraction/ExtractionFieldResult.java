package com.dodaso.ecosystem.elcm.entity.extraction;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpConfidenceTier;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.extraction_field_result -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "extraction_field_result", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_id", "template_field_id"})})
@Getter
@Setter
public class ExtractionFieldResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private ExtractionJob job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_field_id", nullable = false)
    private ExtractionTemplateField templateField;

    @Column(name = "extracted_value", length = 2000)
    private String extractedValue;

    @Column(name = "confidence_score")
    private BigDecimal confidenceScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confidence_tier_id", nullable = true)
    private LkpConfidenceTier confidenceTier;

    @Column(name = "verified_flag", nullable = false)
    private Boolean verifiedFlag;

    @Column(name = "verified_by", length = 255)
    private String verifiedBy;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @Column(name = "corrected_value", length = 2000)
    private String correctedValue;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
