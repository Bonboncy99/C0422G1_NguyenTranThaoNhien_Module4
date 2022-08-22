package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    void addBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(int id);
    Optional<Blog>findById(int id);
}
