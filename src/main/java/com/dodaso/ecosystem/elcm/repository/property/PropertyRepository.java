package com.dodaso.ecosystem.elcm.repository.property;

import com.dodaso.ecosystem.elcm.entity.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
