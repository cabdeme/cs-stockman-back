package com.deme.ahmadou.mcsstockman.controllers;

import com.deme.ahmadou.mcsstockman.model.Product;
import com.deme.ahmadou.mcsstockman.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> getProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return this.productService.getProductById(id);
    }
}
