package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String goToList(Model model){
        model.addAttribute("blogList",iBlogService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String goToAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("mess","Create Success");
        return "redirect:/";
    }
    @GetMapping("update")
    public String goToAdd(@RequestParam int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id).get());
        return "update";
    }
    @PostMapping("/update")
    public String update (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("mess","Create Success");
        return "redirect:/";
    }
    @GetMapping("delete")
    public String goToAdd(@RequestParam int id){
      iBlogService.deleteBlog(id);
        return "redirect:/";
    }
    @GetMapping("detail")
    public String goToDetail(@RequestParam int id, Model model){
        model.addAttribute("blog",iBlogService.findById(id).get());
        return "detail";
    }
}
