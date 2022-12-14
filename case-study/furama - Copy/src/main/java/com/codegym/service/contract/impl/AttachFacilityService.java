package com.codegym.service.contract.impl;

import com.codegym.dto.contract.AttachQuanitity;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.IAttachFacilityRepository;
import com.codegym.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return this.iAttachFacilityRepository.findAll();
    }

    @Override
    public List<AttachFacility> showAttatchFacility(int id) {
        return this.iAttachFacilityRepository.showAttatchFacility(id);
    }

    @Override
    public AttachFacility findById(int id) {
        return this.iAttachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachQuanitity> showAttatchFacilityQuantity(int id) {
        return this.iAttachFacilityRepository.showAttatchFacilityQuantity(id);
    }

}
