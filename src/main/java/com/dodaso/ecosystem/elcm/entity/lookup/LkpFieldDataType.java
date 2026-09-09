package com.dodaso.ecosystem.elcm.entity.lookup;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.lkp_field_data_type -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "lkp_field_data_type")
@Getter
@Setter
public class LkpFieldDataType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "label", nullable = false, length = 150)
    private String label;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
