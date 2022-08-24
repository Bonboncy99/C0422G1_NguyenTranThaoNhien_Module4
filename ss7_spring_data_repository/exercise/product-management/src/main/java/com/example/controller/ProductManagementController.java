package com.example.controller;


import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductManagementController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/create")
    public String goToAdd(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @GetMapping(value = {"/","search"})
    public String goToList(@RequestParam(required = false, defaultValue = "") String nameSearch,Model model,
                           @PageableDefault(size = 2) Pageable pageable){
        model.addAttribute("productList", this.iProductService.findAll(pageable));
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("size",pageable.getPageSize());
        return "list";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("messCreat", "Create Success");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String goToUpdate(@RequestParam int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.updateProduct(product);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messDelete", "Delete Success");
        this.iProductService.deleteProduct(idDelete);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String goToDetail(@RequestParam int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id).get());
        return "detail";
    }

}
