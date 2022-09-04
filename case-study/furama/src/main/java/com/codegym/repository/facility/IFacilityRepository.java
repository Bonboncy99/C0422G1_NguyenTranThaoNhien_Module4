package com.codegym.repository.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility>findAllByFacilityNameContainsAndFacilityType_FacilityTypeNameContains(String name, String facilityTypeName, Pageable pageable);
}
