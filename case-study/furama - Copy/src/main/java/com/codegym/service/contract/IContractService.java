package com.codegym.service.contract;

import com.codegym.dto.contract.ContractPage;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void add(Contract contract);

    void update(Contract contract);

    void delete(int id);

    Contract findById(int id);

    Page<ContractPage> showListContract(Pageable pageable);
}
