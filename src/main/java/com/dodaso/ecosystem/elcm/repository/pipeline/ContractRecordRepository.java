package com.dodaso.ecosystem.elcm.repository.pipeline;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dodaso.ecosystem.elcm.entity.pipeline.ContractRecord;

/**
 * ADDED 2026-10-01 -- the search/lookup methods needed for the Upload Files
 * dialog's Existing Record autocomplete and for generating a new record's
 * record_code (see StageDocumentService.createStagedDocuments() and the new
 * ContractRecordController/RecordProvisioningService).
 */
public interface ContractRecordRepository extends JpaRepository<ContractRecord, Long> {

    Optional<ContractRecord> findByRecordCode(String recordCode);

    /**
     * Backs the Existing Record autocomplete
     * (ContractRecordController.search() -> RecordProvisioningService.search()).
     * Top 20 only -- this is a type-ahead suggestion list, not a full search
     * results page; ordered by recordCode so results are stable/predictable
     * rather than arbitrary DB order.
     */
    List<ContractRecord> findTop20ByRecordCodeContainingIgnoreCaseOrderByRecordCode(String recordCodeFragment);

    /**
     * ADDED 2026-10-02 -- extends the Existing Record autocomplete to also
     * match on counterparty name (per explicit decision in chat: counterparty
     * only for now, more fields later based on feedback). Substring-anywhere,
     * case-insensitive, same as the record-code-only method above and same
     * "top 20, ordered by recordCode" shape -- this is still a type-ahead
     * list, not a results page.
     *
     * A derived-method name for "record code contains X OR counterparty name
     * contains X" isn't expressible cleanly (Spring Data has no OR-across-a-
     * relationship derivation that reads well), so this is a plain JPQL
     * @Query instead. LEFT JOIN on counterparty (not INNER) so records with
     * no counterparty on file (counterparty_id is nullable -- see
     * ContractRecord's Javadoc) still match on record code alone.
     *
     * JPQL has no "Top20" derivation like the method above, so the caller
     * passes PageRequest.of(0, 20) as pageable to get the same cap (see
     * RecordProvisioningService.search()).
     */
    @Query("SELECT DISTINCT cr FROM ContractRecord cr LEFT JOIN cr.counterparty cp "
        + "WHERE LOWER(cr.recordCode) LIKE LOWER(CONCAT('%', :fragment, '%')) "
        + "OR LOWER(cp.name) LIKE LOWER(CONCAT('%', :fragment, '%')) "
        + "ORDER BY cr.recordCode")
    List<ContractRecord> searchTop20ByRecordCodeOrCounterpartyName(@Param("fragment") String fragment, Pageable pageable);

    /**
     * Feeds the sequential record_code generator (see
     * RecordProvisioningService.generateRecordCode()) -- counts existing
     * records already using the given workspace's code as their record_code
     * prefix, so the next one can be numbered one past the current count.
     *
     * KNOWN LIMITATION: this count-then-increment approach is not
     * concurrency-safe -- two "Add to Pipeline" submissions for the same
     * workspace landing in overlapping transactions could compute the same
     * count and collide on the same generated record_code. Acceptable for
     * this stage (same spirit as this codebase's other documented
     * placeholders -- see StagedDocument's OWNER/SOURCE/COMPANY VALUES ARE
     * PLACEHOLDERS note); a real fix is either a DB sequence per workspace
     * or a unique constraint on record_code with retry-on-conflict, not
     * implemented here.
     */
    long countByWorkspace_CodeAndRecordCodeStartingWith(String workspaceCode, String recordCodePrefix);
}
