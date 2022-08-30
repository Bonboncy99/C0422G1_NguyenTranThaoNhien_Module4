package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> setUpCart() {
        return new HashMap<>();
    }

    @GetMapping("/")
    public String goToList(Model model) {
        model.addAttribute("productList", this.iProductService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String goToDetail(@RequestParam("id") int id, Model model) {
        Product product = this.iProductService.findById(id);
        if (product == null) {
            return "/404error";
        }
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam(defaultValue = "0") int id,
                            @SessionAttribute Map<Product, Integer> cart,
                            Model model) {
        Product product = this.iProductService.findById(id);
        if (product == null) {
            return "/404error";
        }
        this.iCartService.addToCart(cart,product);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String goToCart(@SessionAttribute Map <Product,Integer>cart, Model model){
        model.addAttribute("cart",cart);
        model.addAttribute("itemQuantity",this.iCartService.countItem(cart));
        model.addAttribute("total",this.iCartService.total(cart));
        return "cart";
    }

    @GetMapping("/changequantity")
    public String changeQuantity(@SessionAttribute Map<Product,Integer>cart,
                                 @RequestParam(defaultValue = "0") int id,
                                 @RequestParam("expression") String expression,
                                 Model model){

        Product product = this.iProductService.findById(id);
        if (product == null) {
            return "/404error";
        }
        this.iCartService.changeCart(cart,product,expression);
        return "redirect:/cart";
    }

    @GetMapping("/removeproduct")
    public String removeproduct(@RequestParam int id,
                                @SessionAttribute Map<Product,Integer>cart){
        Product product = this.iProductService.findById(id);
        if (product == null) {
            return "/404error";
        }
        this.iCartService.removeProduct(cart,product);
        return "redirect:/cart";
    }
    @GetMapping("/payOff")
    public String payOff(@SessionAttribute Map<Product,Integer>cart){
        this.iCartService.pay(cart);
        return "redirect:/cart";
    }

}
