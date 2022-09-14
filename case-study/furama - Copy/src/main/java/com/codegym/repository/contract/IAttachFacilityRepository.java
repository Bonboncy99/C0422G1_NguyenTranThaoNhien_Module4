package com.codegym.repository.contract;

import com.codegym.dto.contract.AttachQuanitity;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {


    @Query(value = "select af.*\n" +
            "from attach_facility af\n" +
            "left join contract_detail ctdt on ctdt.attach_facility_id= af.attach_facility_id\n" +
            "where ctdt.contract_id = :contract_id",nativeQuery = true)
    List<AttachFacility>showAttatchFacility(@Param("contract_id") int id);


    @Query(value = "SELECT\n" +
            "    af.attach_facility_id AS attachId,\n" +
            "    af.attach_facility_name AS attachName,\n" +
            "    af.price,\n" +
            "    af.unit,\n" +
            "    af.status,\n" +
            "    SUM(ctdt.quantity) AS quantity\n" +
            "    FROM\n" +
            "    attach_facility af\n" +
            "    LEFT JOIN\n" +
            "    contract_detail ctdt ON ctdt.attach_facility_id = af.attach_facility_id\n" +
            "            WHERE\n" +
            "    ctdt.contract_id = :contract_id" +
            "    GROUP BY ctdt.attach_facility_id",nativeQuery = true)
    List<AttachQuanitity>showAttatchFacilityQuantity(@Param("contract_id") int id);

}
