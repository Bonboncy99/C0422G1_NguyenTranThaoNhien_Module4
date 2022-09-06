package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void addBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(int id);

    Optional<Blog> findById(int id);

    Page<Blog> findAllByBlogNameContainingAndCategories_Name(String blogName, String categoryName, Pageable pageable);

    Page<Blog> findByCategories_Id(int id, Pageable pageable);

    Page<Blog> search(String name, Pageable pageable);
}
