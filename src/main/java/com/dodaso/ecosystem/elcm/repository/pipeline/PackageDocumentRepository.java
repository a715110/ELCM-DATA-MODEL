package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.pipeline.PackageDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageDocumentRepository extends JpaRepository<PackageDocument, Long> {

    long countByContractPackage_Id(Long packageId);

    // Roles-assigned progress (e.g. the "1/1 roles" display on the packages
    // table) -- counts documents whose role has actually been set to
    // something other than UNDEFINED. This mirrors the real package
    // submission validation rule (SDS 4.1): a package can't submit while
    // any document's role is UNDEFINED.
    long countByContractPackage_IdAndDocumentRole_CodeNot(Long packageId, String undefinedCode);
}
