package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import com.codegym.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.management.relation.Role;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/showCreate")
    public String goToAdd(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("messCreate", "Create Success");
        return "redirect:/blog/";
    }

    @GetMapping("/showUpdate")
    public String goToAdd(@RequestParam int id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id).get());
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success");
        return "redirect:/blog/";
    }

    @GetMapping("/delete")
    public String goToAdd(@RequestParam int idDelete) {
        iBlogService.deleteBlog(idDelete);
        return "redirect:/blog/";
    }

    @GetMapping("detail")
    public String goToDetail(@RequestParam int id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id).get());
        return "detail";
    }

    @GetMapping(value = {"/search", "/"})
    public String search(Principal principal,
                         @RequestParam Optional<Integer> page,
                         @RequestParam(required = false, defaultValue = "") String category,
                         @RequestParam(required = false, defaultValue = "") String nameSearch,
                         @PageableDefault(size = 7, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Blog> blogList = this.iBlogService.findAllByBlogNameContainingAndCategories_Name(nameSearch, category, pageable);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(loginedUser.getAuthorities());
//        String userRole;
//        for (GrantedAuthority grantedAuthority : grantedAuthorities) {
//            if (grantedAuthority.equals("ROLE_ADMIN")) {
//                userRole = "admin";
//            } else if (grantedAuthority.equals("ROLE_USER")) {
//                userRole = "user";
//            }
//        }
//        model.addAttribute("userRole",userRole);



//        Collection<GrantedAuthority> grantedAuthorityList = loginedUser.getAuthorities();
//        if (grantedAuthorityList.size() == 2) {
//            model.addAttribute("admin", "admin");
//        } else if (grantedAuthorityList.size() == 1) {
//            model.addAttribute("user", "user");
//        } else {
//            model.addAttribute("notUser", "notUser");
//        }




        model.addAttribute("categoryList", this.iCategoryService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("category", category);
        model.addAttribute("blogList", blogList);
        model.addAttribute("size", pageable.getPageSize());
        return "list";
    }
}
