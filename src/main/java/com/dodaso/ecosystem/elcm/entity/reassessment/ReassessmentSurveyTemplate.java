package com.dodaso.ecosystem.elcm.entity.reassessment;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * ADDED 2026-11-11 -- a survey a case owner can send for a reassessment (FC-6). A template is only
 * a starting point: when a survey is sent, its questions are copied onto the survey response, so
 * editing a template later never changes a survey that was already sent.
 *
 * <p>Kept deliberately small so the survey design can change after Peter's mockups: new answer
 * types are added in code (ReassessmentAnswerRules), not in the schema.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reassessment_survey_template")
@Getter
@Setter
public class ReassessmentSurveyTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder = 0;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = Boolean.TRUE;

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
