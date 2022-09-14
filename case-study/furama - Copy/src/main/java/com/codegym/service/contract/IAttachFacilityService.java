package com.codegym.service.contract;

import com.codegym.dto.contract.AttachQuanitity;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility>findAll();
    List<AttachFacility>showAttatchFacility(@Param("contract_id") int id);
    AttachFacility findById(int id);
    List<AttachQuanitity>showAttatchFacilityQuantity(int id);

}
