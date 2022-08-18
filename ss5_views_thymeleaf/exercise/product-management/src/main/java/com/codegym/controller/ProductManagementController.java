package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String goToAdd(Model model){
        model.addAttribute("product",new Product());
        return "add";
    }

    @GetMapping("/")
    public String goToList(Model model){
        model.addAttribute("productList",this.iProductService.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("messCreat","Create Success");
        return "redirect:/";
    }

    @GetMapping ("/update")
    public String goToUpdate(@RequestParam int id,Model model){
        model.addAttribute("product",this.iProductService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.updateProduct(product);
        redirectAttributes.addFlashAttribute("messUpdate","Update Success");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idDelete,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("messDelete","Delete Success");
        this.iProductService.deleteProduct(idDelete);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String goToDetail(@RequestParam int id, Model model){
        model.addAttribute("product",this.iProductService.findById(id));
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String nameSearch, Model model){
        model.addAttribute("productList",this.iProductService.searchByName(nameSearch));
        return "list";
    }
}
