package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void addBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(int id);
    Optional<Blog> findById(int id);

}
