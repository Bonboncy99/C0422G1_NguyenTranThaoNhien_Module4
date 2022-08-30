package com.codegym.service;

import com.codegym.model.Product;

import java.util.Map;

public interface ICartService {
    void changeCart(Map<Product,Integer> cart, Product product,String expression);
    void addToCart(Map<Product,Integer>cart,Product product);
    double total(Map<Product,Integer> cart);
    void removeProduct(Map<Product,Integer> cart, Product product);
    int countItem(Map<Product,Integer>cart);
    void pay(Map<Product,Integer>cart);
}
