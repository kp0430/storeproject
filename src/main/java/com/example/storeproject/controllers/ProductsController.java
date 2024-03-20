package com.example.storeproject.controllers;

import com.example.storeproject.models.Product;
import com.example.storeproject.models.ProductDto;
import com.example.storeproject.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController{
    @Autowired
   private ProductsRepository repo;
    @GetMapping({"","/"})
    public String showProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/index";
    }

    public String showCreatePage(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("ProductDto",productDto);
        return "products/CreateProduct";
    }

}
