package com.codegym.service.impl;


import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogSerivce implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public void addBlog(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return this.iBlogRepository.findById(id);
    }



    @Override
    public Page<Blog> findAllByBlogNameContainingAndCategories_Name(String blogName, String categoryName, Pageable pageable) {
        if (categoryName.equals("")){
            return this.iBlogRepository.findAllByBlogNameContaining(blogName,pageable);
        } else {
            return this.iBlogRepository.findAllByBlogNameContainingAndCategories_Name(blogName,categoryName,pageable);
        }
    }


    @Override
    public Page<Blog> findByCategories_Id(int id, Pageable pageable) {
        return this.iBlogRepository.findByCategories_Id(id,pageable);
    }


}
