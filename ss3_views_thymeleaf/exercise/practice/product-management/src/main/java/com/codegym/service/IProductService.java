package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Product findById(int id);
    List<Product> searchByName(String name);

}
