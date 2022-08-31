package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

     Page<Blog>findAllByBlogNameContainingAndCategories_Name(String blogName, String categoryName, Pageable pageable);
     Page<Blog>findAllByBlogNameContaining(String blogName, Pageable pageable);
}
