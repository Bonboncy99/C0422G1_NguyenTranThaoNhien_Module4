package com.codegym.controller;

import com.codegym.dto.contract.ContractPage;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/contract")
@Controller
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;
//    @GetMapping("")
//    public String goToServiceList(@PageableDefault(20)Pageable pageable, Model model) {
//        model.addAttribute("contractPage",this.iContractService.findAll(pageable));
//        model.addAttribute("contractDetailList",this.iContractDetailService.findAll());
//        model.addAttribute("attachFacilityList",this.iAttachFacilityService.findAll());
//        List<Contract> contracts = this.iContractService.findAll(pageable).getContent();
//        model.addAttribute("employeeList",this.iEmployeeService.findAll());
//        model.addAttribute("facilityList",this.iCustomerService.findAll());
//        model.addAttribute("facilityList",this.iFacilityService.findAll());
//        return "contract/list";
//    }

//    @GetMapping("/add")
//    public String showFormAdd(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("newContract",new Contract());
//        return "redirect:/contract";
//    }

    @PostMapping("/add")
    public String add(@ModelAttribute("newContract") Contract newContract, RedirectAttributes redirectAttributes) {
        this.iContractService.add(newContract);
        redirectAttributes.addFlashAttribute("mess","Create Contract success");
        return "redirect:/contract";
    }

    @GetMapping("/update")
    public String goToServiceUpdate() {
        return "contract/update";
    }

//    @GetMapping("/attachFacility")
//    public String showAttach(Model model, @RequestParam int contractId) {
////        List<ContractDetail>contractDetailList = this.iContractDetailService.findByContract_ContractId(contractId);
////        List<AttachFacility>attachFacilityList = this.iAttachFacilityService.findByContractDetailList(contractDetailList);
//
//
//        return "contract/detail";
//    }
    @GetMapping("addAF")
    public String addAttachFacility(int idContract, int attachID, int quantity,RedirectAttributes redirectAttributes){
        Contract contract = this.iContractService.findById(idContract);
        AttachFacility attachFacility = this.iAttachFacilityService.findById(attachID);
        if (contract!=null && attachFacility!=null){
            ContractDetail contractDetail = new ContractDetail(contract,attachFacility,quantity);
            this.iContractDetailService.Add(contractDetail);
        }
        redirectAttributes.addFlashAttribute("messAction","Add Attach facility success");
        return "redirect:/contract";
    }
    @GetMapping("")
    public String goToList(Model model, @PageableDefault(5) Pageable pageable) {
        model.addAttribute("attachList",this.iAttachFacilityService.findAll());
        model.addAttribute("customerList", this.iCustomerService.findAll());
        model.addAttribute("employeeList", this.iEmployeeService.findAll());
        model.addAttribute("facilityList", this.iFacilityService.findAll());
        model.addAttribute("newContract", new Contract());
        model.addAttribute("contractPageList", this.iContractService.showListContract(pageable));
        Page<ContractPage> contractPageList = this.iContractService.showListContract(pageable);
        return "contract/list";
    }

//    @GetMapping("")
//    public String goToList(Model model, @PageableDefault(5) Pageable pageable) {
//        model.addAttribute("newAF", new ContractDetail());
//        model.addAttribute("attachList",this.iAttachFacilityService.findAll());
//        model.addAttribute("customerList", this.iCustomerService.findAll());
//        model.addAttribute("employeeList", this.iEmployeeService.findAll());
//        model.addAttribute("facilityList", this.iFacilityService.findAll());
//        model.addAttribute("newContract", new Contract());
//        model.addAttribute("contractPageList", this.iContractService.showListContract(pageable));
//        Page<ContractPage> contractPageList = this.iContractService.showListContract(pageable);
//        return "contract/list";
//    }
}
