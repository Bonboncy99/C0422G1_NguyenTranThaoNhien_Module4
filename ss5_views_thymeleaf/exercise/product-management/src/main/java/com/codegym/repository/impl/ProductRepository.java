package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer,Product>integerProductMap;
    static {
        integerProductMap = new HashMap<>();
        integerProductMap.put(1,new Product(1,"Bánh",10,"ăn","BON"));
        integerProductMap.put(2,new Product(2,"Kẹo",20,"ăn","NHIÊN"));
        integerProductMap.put(3,new Product(3,"Sữa",30,"Uống","CY"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(integerProductMap.values());
    }

    @Override
    public void addProduct(Product product) {
        int id = (int) (Math.random()*1000);
        product.setId(id);
        integerProductMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        integerProductMap.remove(id);
    }

    @Override
    public void updateProduct(Product product) {
        integerProductMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return integerProductMap.get(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product>productList = new ArrayList<>();
        for (Product product:integerProductMap.values()) {
            if (product.getName().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }
}
