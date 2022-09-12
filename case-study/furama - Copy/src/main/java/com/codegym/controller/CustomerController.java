package com.codegym.controller;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

//    @GetMapping("")
//    public String goToCustomerList(Model model,
//                                   @PageableDefault(size = 10) Pageable pageable) {
//        model.addAttribute("customerList", this.iCustomerService.findAll(pageable));
//        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
//        return "customer/list";
//    }

    @GetMapping("/add")
    public String goToCustomerListAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes, Model model) {
        customerDto.validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
            return "customer/add";
        }

        CustomerType customerType = this.iCustomerTypeService.findById(customerDto.getCustomerType());
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerType);
        this.iCustomerService.addCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Create success!");
        return "redirect:/customer";
    }

    @GetMapping("/update")
    public String goToCustomerListUpdate(@RequestParam("idUpdate") int idUpdate, Model model) {
        Customer customer = this.iCustomerService.findById(idUpdate);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customer);
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());

        return "customer/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customerDto") @Valid  CustomerDto customerDto,
                         BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        customerDto.validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        CustomerType customerType = this.iCustomerTypeService.findById(customerDto.getCustomerId());
        customer.setCustomerType(customerType);
        this.iCustomerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Update success!");
        return "redirect:/customer";
    }


    @PostMapping("/delete")
    public String update(@RequestParam("idDelete") int idDelete, RedirectAttributes redirectAttributes) {
        this.iCustomerService.deleteCustomer(idDelete);
        redirectAttributes.addFlashAttribute("mess", "Delete success!");
        return "redirect:/customer";
    }

    @GetMapping(value = {"", "/search"})
    public String search(Model model,
                         @RequestParam(required = false, defaultValue = "") String nameSearch,
                         @RequestParam(required = false, defaultValue = "") String customerTypeName,
                         @RequestParam(required = false, defaultValue = "") String phoneSearch,
                         @RequestParam(required = false, defaultValue = "") String emailSearch,
                         @PageableDefault(size = 3, sort = "customerId", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("customerList", this.iCustomerService.findAllByCustomerNameContainsAndCustomerType_CustomerTypeNameContainsAndPhoneNumberContainsAndEmailContains
                (nameSearch, customerTypeName, phoneSearch, emailSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("customerTypeName", customerTypeName);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        model.addAttribute("size", pageable.getPageSize());
        return "customer/list";
    }

}
