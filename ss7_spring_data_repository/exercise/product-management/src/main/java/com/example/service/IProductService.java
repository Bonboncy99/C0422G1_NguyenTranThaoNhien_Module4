package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void addProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Optional<Product> findById(int id);
    Page<Product> searchByName(String name, Pageable pageable);
}
