package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {

//    @Query(value = "select af.* from attach_facility af left join contract_detail ctdt on ctdt.attach_facility_id = af.attach_facility_id left join contract ct on ct.contract_id = ctdt.contract_id left join customer cu on cu.customer_id = ct.customer_id where cu.customer_id= :customerId;",nativeQuery = true)
//    List<AttachFacility>(@Param("customerId") Integer customerId);

//    List<AttachFacility> findByContractDetailList(List<ContractDetail> contractDetailList);
    @Query(value = "select af.*\n" +
            "from attach_facility af\n" +
            "left join contract_detail ctdt on ctdt.attach_facility_id= af.attach_facility_id\n" +
            "left join contract ct on ct.contract_id = ctdt.contract_id\n" +
            "where ct.contract_id = :contract_id",nativeQuery = true)
    List<AttachFacility>showAttatchFacility(@Param("contract_id") int id);
}
