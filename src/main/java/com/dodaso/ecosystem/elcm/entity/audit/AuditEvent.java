package com.dodaso.ecosystem.elcm.entity.audit;

import jakarta.persistence.*;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpAuditEntityType;
import com.dodaso.ecosystem.elcm.entity.lookup.LkpAuditEventType;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.audit_event -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "audit_event")
@Getter
@Setter
public class AuditEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id", nullable = false)
    private LkpAuditEntityType entityType;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_type_id", nullable = false)
    private LkpAuditEventType eventType;

    @Column(name = "actor_id", length = 255)
    private String actorId;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    @Column(name = "payload")
    private String payload;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
