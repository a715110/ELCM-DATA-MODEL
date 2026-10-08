package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.PackageDocument;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PackageDocumentRepository extends JpaRepository<PackageDocument, Long> {

    long countByContractPackage_Id(Long packageId);

    // Roles-assigned progress (e.g. the "1/1 roles" display on the packages
    // table) -- counts documents whose role has actually been set to
    // something other than UNDEFINED. This mirrors the real package
    // submission validation rule (SDS 4.1): a package can't submit while
    // any document's role is UNDEFINED.
    long countByContractPackage_IdAndDocumentRole_CodeNot(Long packageId, String undefinedCode);

    // ADDED 2026-10-07 -- used by StageDocumentService.deleteStaged(): a
    // staged document that already belongs to a package cannot be deleted.
    boolean existsByStagedDocument_Id(Long stagedDocumentId);

    // ADDED 2026-10-07 -- package write paths (create, add, remove).

    /** Which of these staged documents already belong to a package. */
    List<PackageDocument> findByStagedDocument_IdIn(Collection<Long> stagedDocumentIds);

    Optional<PackageDocument> findByContractPackage_IdAndStagedDocument_Id(Long packageId, Long stagedDocumentId);

    /**
     * A package's member documents with the staged document, its workspace and the
     * role loaded in the same query, so callers can read them after the query's own
     * transaction has ended (spring.jpa.open-in-view is false).
     */
    @Query("SELECT pd FROM PackageDocument pd "
        + "JOIN FETCH pd.stagedDocument sd "
        + "JOIN FETCH sd.workspace "
        + "LEFT JOIN FETCH sd.targetRecord "
        + "JOIN FETCH pd.documentRole "
        + "WHERE pd.contractPackage.id = :packageId ORDER BY pd.id")
    List<PackageDocument> findDetailedByPackageId(@org.springframework.data.repository.query.Param("packageId") Long packageId);
}
