package com.deme.ahmadou.mcsstockman.services;

import com.deme.ahmadou.mcsstockman.model.Product;
import com.deme.ahmadou.mcsstockman.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;



    public List<Product> getProducts(Long id){
        return this.productRepository.findProductsByDepotIdIs(id);
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Product getProductById(long id){
        return this.productRepository.findById(id).orElse(null);
    }

}
