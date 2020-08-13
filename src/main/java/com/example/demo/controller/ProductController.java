package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping()
    public String index(Model model) {
        List<Product> products = productService.getAllProduct();

        model.addAttribute("products", products);

        return "listproduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String sellProduct(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products",products);
        return "sellproduct";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }
}
