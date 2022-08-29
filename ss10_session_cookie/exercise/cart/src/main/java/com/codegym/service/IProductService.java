package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addProduct (Product product);
    void updateProduct (Product product);
    void deleteProduct (int id);
    Product findById(int id);
}
