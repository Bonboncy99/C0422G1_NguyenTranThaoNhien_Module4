package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    void add(Category category);
    void update(Category category);
    void delete(int id);
    Optional<Blog> findById(int id);

}
