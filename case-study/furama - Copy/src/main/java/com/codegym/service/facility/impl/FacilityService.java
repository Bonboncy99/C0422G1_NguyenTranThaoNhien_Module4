package com.codegym.service.facility.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return this.iFacilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return this.iFacilityRepository.findAll();
    }

    @Override
    public void add(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public void update(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        this.iFacilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(int id) {
        return this.iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Facility> search(String name, String facilityTypeName, Pageable pageable) {
        return this.iFacilityRepository.findAllByFacilityNameContainsAndFacilityType_FacilityTypeNameContains(name,facilityTypeName,pageable);
    }
}
