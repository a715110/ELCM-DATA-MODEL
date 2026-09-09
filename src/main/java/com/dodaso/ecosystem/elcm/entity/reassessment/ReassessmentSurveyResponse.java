package com.dodaso.ecosystem.elcm.entity.reassessment;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to elcm.reassessment_survey_response -- generated from the authoritative dodaso-platform.dbs
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
@Table(name = "reassessment_survey_response")
@Getter
@Setter
public class ReassessmentSurveyResponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reassessment_case_id", nullable = false)
    private ReassessmentCase reassessmentCase;

    @Column(name = "business_unit", length = 255)
    private String businessUnit;

    @Column(name = "respondent", length = 255)
    private String respondent;

    @Column(name = "response_data")
    private String responseData;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
