package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("create")
    public String goToAdd(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",this.iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("messCreate","Create Success");
        return "redirect:/";
    }
    @GetMapping("update")
    public String goToAdd(@RequestParam int id, Model model){
        model.addAttribute("blog",this.iBlogService.findById(id).get());
        model.addAttribute("categoryList",this.iCategoryService.findAll());
        return "update";
    }
    @PostMapping("/update")
    public String update (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("messUpdate","Update Success");
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String goToAdd(@RequestParam int idDelete){
        iBlogService.deleteBlog(idDelete);
        return "redirect:/";
    }
    @GetMapping("detail")
    public String goToDetail(@RequestParam int id, Model model){
        model.addAttribute("blog",this.iBlogService.findById(id).get());
        return "detail";
    }

    @GetMapping(value = {"/search","/"})
    public String search(@RequestParam Optional <Integer> page, @RequestParam(required = false,defaultValue = "") String category,@RequestParam(required = false,defaultValue = "") String nameSearch,Pageable pageable, Model model){
        pageable= PageRequest.of(page.orElse(0),7);
        Page<Blog> blogList =this.iBlogService.findAllByBlogNameContainingAndCategories_Name(nameSearch,category,pageable);
        model.addAttribute("categoryList",this.iCategoryService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("category",category);
        model.addAttribute("blogList",blogList);
        model.addAttribute("size",pageable.getPageSize());
        return "list";
    }

}
