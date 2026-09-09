package com.dodaso.ecosystem.elcm.entity.extraction;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpFieldDataType;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.extraction_template_field -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "extraction_template_field", uniqueConstraints = {@UniqueConstraint(columnNames = {"template_id", "field_key"})})
@Getter
@Setter
public class ExtractionTemplateField implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private ExtractionTemplate template;

    @Column(name = "field_key", nullable = false, length = 100)
    private String fieldKey;

    @Column(name = "label", nullable = false, length = 200)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_type_id", nullable = false)
    private LkpFieldDataType dataType;

    @Column(name = "is_critical", nullable = false)
    private Boolean isCritical;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
