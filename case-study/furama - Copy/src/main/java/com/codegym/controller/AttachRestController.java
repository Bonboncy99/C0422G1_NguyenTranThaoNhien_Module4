package com.codegym.controller;

import com.codegym.dto.contract.ContractPage;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.contract.impl.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@RequestMapping("/attachRest")
public class AttachRestController {
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private IContractDetailService iContractDetailService;

//    @GetMapping("")
//    public ResponseEntity<Page<ContractPage>> showList(@PageableDefault(5)Pageable pageable){
//        Page<ContractPage>contractPages = this.iContractService.showListContract(pageable);
//        if (contractPages.hasContent()){
//            return new ResponseEntity<>(contractPages,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


    @GetMapping("/attachRest")
    public ResponseEntity<List<AttachFacility>> showList(@RequestParam int id){
        List<AttachFacility>attachFacilityList = this.iAttachFacilityService.showAttatchFacility(id);
        if (attachFacilityList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityList,HttpStatus.OK);
    }

//    @GetMapping("/attachRest")
//    public ResponseEntity<List<ContractDetail>> showList(@RequestParam int id){
//        List<ContractDetail>contractDetailList = this.iContractDetailService.findByContract_ContractId(id);
////        List<AttachFacility>attachFacilityList = this.iAttachFacilityService.showAttatchFacility(id);
//        if (contractDetailList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(contractDetailList,HttpStatus.OK);
//    }

}
