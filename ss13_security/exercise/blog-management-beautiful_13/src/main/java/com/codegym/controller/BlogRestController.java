package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
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
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    //    Xem danh sách category
    @GetMapping("/categoryList")
    public ResponseEntity<List<Category>> goToCategoryList() {
        List<Category> categoryList = this.iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    //    Xem danh sách các bài viết
    @GetMapping("")
    public ResponseEntity<Page<Blog>> goToBlogList1(@PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findAll(pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    //    Xem danh sách các bài viết của một category
    @GetMapping("/categories")
    public ResponseEntity<Page<Blog>> findByCategoryName(@RequestParam int id, @PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findByCategories_Id(id, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Blog> detail(@RequestParam int id) {
        Blog blog = this.iBlogService.findById(id).orElse(null);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //    tìm bài viết theo tên
    @GetMapping("/searchName")
    public ResponseEntity<Page<Blog>> searchByName(@RequestParam(defaultValue = "") String name,
                                                   Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.search(name, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
