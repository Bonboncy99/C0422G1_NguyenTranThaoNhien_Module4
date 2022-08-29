package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        this.iProductRepository.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id).orElse(null);
    }
}
