package com.dodaso.ecosystem.elcm.repository.pipeline;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dodaso.ecosystem.elcm.entity.pipeline.StagedDocument;

public interface StagedDocumentRepository extends JpaRepository<StagedDocument, Long> {

    long countByStatus_Code(String code);

    /**
     * ADDED 2026-09-29 -- fixes StageDocumentService.toDraft() seeing
     * doc.getWorkspace() as null (reported as a null-vs-NPE symptom, but the
     * real cause is that workspace/targetRecord are LAZY @ManyToOne
     * associations and StageDocumentService.loadStagedDocuments() -- despite
     * being annotated @Transactional -- is called via self-invocation
     * (`this.loadStagedDocuments(...)` from findStaged() in the same class),
     * which bypasses Spring's transactional proxy entirely. What actually
     * runs the query is JpaRepository.findAll()'s OWN short-lived
     * transaction, which is already closed (spring.jpa.open-in-view=false)
     * by the time toDraft() tries to touch the lazy associations -- same
     * self-invocation trap already documented/fixed once in this codebase
     * for ThumbnailStatusUpdater.
     *
     * Rather than relocating loadStagedDocuments() to a separate bean (works,
     * but still leaves an N+1 query -- one extra SELECT per row once lazy
     * loading DOES succeed), this eagerly fetches the two associations
     * toDraft() actually reads (workspace, targetRecord) in the same query,
     * so there is no lazy access left to fail regardless of transaction
     * boundaries. workspace is JOIN FETCH (inner) since workspace_id is
     * NOT NULL on staged_document; targetRecord is LEFT JOIN FETCH since
     * target_record_id is nullable. contractType/routingIntent/status are
     * NOT fetched here since toDraft()/mapToRow() never read them -- adding
     * more JOIN FETCHes than are actually used would just add cost (and, for
     * more than one *collection* fetch, risk a Cartesian product) with
     * nothing to show for it.
     *
     * REVISED 2026-10-03 -- added LEFT JOIN FETCH on targetRecord's own
     * counterparty/contractType/status/workspace: the Stage Documents
     * dashboard's new Record-column hover preview (see
     * StageDocumentService.toDraft()) reads all four off the linked
     * ContractRecord, which are themselves LAZY @ManyToOne associations on
     * ContractRecord (same reasoning as workspace/targetRecord above -- read
     * them lazily post-transaction and it's a silent null, not an
     * exception, same trap this method's original fix already covers).
     * Still no Cartesian-product risk: every one of these is a
     * single-valued (@ManyToOne) association, never a collection.
     *
     * REVISED 2026-10-07 -- the WHERE NOT EXISTS leaves out documents that
     * already belong to a package: once grouped, a document is worked on
     * through its package, not through this inbox list. Removing it from a
     * draft package makes it appear here again. StagedDocument's
     * @SQLRestriction (deleted_at IS NULL) still applies on top.
     */
    @Query("SELECT s FROM StagedDocument s "
        + "JOIN FETCH s.workspace "
        + "LEFT JOIN FETCH s.targetRecord tr "
        + "LEFT JOIN FETCH tr.counterparty "
        + "LEFT JOIN FETCH tr.contractType "
        + "LEFT JOIN FETCH tr.status "
        + "LEFT JOIN FETCH tr.workspace "
        + "WHERE NOT EXISTS (SELECT pd.id FROM PackageDocument pd WHERE pd.stagedDocument = s)")
    List<StagedDocument> findAllWithWorkspaceAndTargetRecord();
}