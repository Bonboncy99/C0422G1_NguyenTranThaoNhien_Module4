package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepository.findAll(pageable);
    }

    @Override
    public void addProduct(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        this.iProductRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        if (name.equals("")){
            return this.iProductRepository.findAll(pageable);
        } else {
            return this.iProductRepository.findAllByNameContaining(name,pageable);
        }
    }

}
