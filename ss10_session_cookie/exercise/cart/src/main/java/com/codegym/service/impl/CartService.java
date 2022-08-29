package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CartService implements ICartService {
    @Autowired
    private IProductService iProductService;

    @Override
    public void changeCart(Map<Product, Integer> cart, Product product, String expression) {
        if (expression.equals("+")) {
            cart.put(product, cart.get(product)+1);
        } else  if (expression.equals("-")) {
            cart.put(product, cart.get(product)-1);
        }
        if (cart.get(product) == 0) {
            cart.remove(product);
        }
    }

    @Override
    public void addToCart(Map<Product, Integer> cart, Product product) {
        if (cart.containsKey(product)){
            cart.put(product,cart.get(product) + 1);
        } else {
            cart.put(product,1);
        }
    }


    @Override
    public double total(Map<Product, Integer> cart) {
        double total = 0;
        for (Product product: cart.keySet()) {
            total+=product.getPrice()*cart.get(product);
        }
        return total;
    }
}
