package com.deme.ahmadou.mcsstockman.services;


import com.deme.ahmadou.mcsstockman.model.Depot;
import com.deme.ahmadou.mcsstockman.model.Product;
import com.deme.ahmadou.mcsstockman.repository.DepotRepository;
import com.deme.ahmadou.mcsstockman.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepotService {


    private final DepotRepository depotRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DepotService(DepotRepository depotRepository, ProductRepository productRepository) {
        this.depotRepository = depotRepository;
        this.productRepository = productRepository;
    }

    public List<Depot> getDepot(){
        return depotRepository.findAll().stream().collect(Collectors.toList());
    }

    public Depot addDepot(Depot depot){
        Depot savedDepot =  depotRepository.save(depot);

        log.info("New depot saved: {}",savedDepot);

        return savedDepot;
    }

    public Depot getDepotById(Long id){
        return depotRepository.findById(id).get();
    }

    public List<Product> getProducts(Long id) {
        //return productRepository.find
        //return depotRepository.findProductsById(id);
        return productRepository.findProductsByDepotIdIs(id);
    }

    public Product addProductToDepot(Long id, Product product) {
        Depot findDepot = this.depotRepository.findById(id).get();
        product.setDepot(findDepot);
        System.out.println("Before save: "+product);
        return this.productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        Product productToUpdate = this.productRepository.findById(product.getId()).orElseThrow(()-> new IllegalStateException("Product with id "+id+" does not exist"));
        return this.productRepository.save(product);
    }
}
