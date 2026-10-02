package com.dodaso.ecosystem.elcm.repository.property;

import java.util.Optional;

import com.dodaso.ecosystem.elcm.entity.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    /**
     * ADDED 2026-10-01 -- Property is the owning side of the
     * contract_record_id FK (see Property's Javadoc: unidirectional,
     * owning-side-only relationships), so there's no
     * contractRecord.getProperty() to walk the other way. Backs the Stage
     * Documents dashboard's new file-preview "record details" panel
     * (RecordProvisioningService.getRecordDetail()), which needs a
     * record's address by going property -> address.
     */
    Optional<Property> findByContractRecord_Id(Long contractRecordId);
}
