package com.dodaso.ecosystem.elcm.repository.pipeline;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodaso.ecosystem.elcm.entity.pipeline.Counterparty;

/**
 * ADDED 2026-10-01 alongside the new elcm.counterparty table -- see
 * Counterparty's own Javadoc for the full context.
 *
 * findByNameIgnoreCase() backs RecordProvisioningService.createNewRecord()'s
 * find-or-create: turning the dialog's free-text Counterparty field into a
 * real Counterparty row means finding an existing one by name first so the
 * same counterparty doesn't get a duplicate row every time a new lease
 * names it, and only creating a new one when no match exists.
 * Case-insensitive since the free text comes from an unconstrained dialog
 * input (see UploadFilesBean), where "Acme Corp" and "ACME CORP" should
 * resolve to the same counterparty.
 */
public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {
    Optional<Counterparty> findByNameIgnoreCase(String name);
}
