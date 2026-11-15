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
 * ADDED 2026-11-11 -- one question of a survey template. answer_type is one of TEXT, NUMBER, DATE,
 * YES_NO or CHOICE (see ReassessmentAnswerRules in elcm-service). For CHOICE the options are in
 * choices, one per line.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reassessment_survey_question")
@Getter
@Setter
public class ReassessmentSurveyQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private ReassessmentSurveyTemplate template;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder = 0;

    @Column(name = "question_text", nullable = false, length = 1000)
    private String questionText;

    @Column(name = "answer_type", nullable = false, length = 30)
    private String answerType;

    @Column(name = "choices", length = 1000)
    private String choices;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired = Boolean.TRUE;

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
