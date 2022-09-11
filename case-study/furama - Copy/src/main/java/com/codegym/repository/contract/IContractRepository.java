package com.codegym.repository.contract;

import com.codegym.dto.contract.ContractPage;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "SELECT \n" +
            "    ct.contract_id AS id,\n" +
            "    f.facility_name AS facilityName,\n" +
            "    c.customer_name AS customerName,\n" +
            "    ct.start_date AS startDate,\n" +
            "    ct.end_date AS endDate,\n" +
            "    ct.deposit,\n" +
            "    f.cost + IFNULL(SUM(af.price * ctdt.quantity), 0) AS total\n" +
            "FROM\n" +
            "    contract ct\n" +
            "        LEFT JOIN\n" +
            "    contract_detail ctdt ON ctdt.contract_id = ct.contract_id\n" +
            "        LEFT JOIN\n" +
            "    attach_facility af ON af.attach_facility_id = ctdt.attach_facility_id\n" +
            "        LEFT JOIN\n" +
            "    customer c ON c.customer_id = ct.customer_id\n" +
            "        LEFT JOIN\n" +
            "    facility f ON f.facility_id = ct.facility_id\n" +
            "GROUP BY ct.contract_id",
            nativeQuery = true,countQuery = "select count(*) from contract")
    Page<ContractPage> showListContract(Pageable pageable);
}
