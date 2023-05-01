package com.deme.ahmadou.mcsstockman.controllers;

import com.deme.ahmadou.mcsstockman.model.Depot;
import com.deme.ahmadou.mcsstockman.model.Product;
import com.deme.ahmadou.mcsstockman.services.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/depots")
@CrossOrigin(origins = "*")
public class DepotController {


    private DepotService depotService;

    @Autowired
    public DepotController(DepotService depotService){
        this.depotService = depotService;
    }

    /* get the list of depots */
    @GetMapping
    public List<Depot> getDepots(){
        return depotService.getDepot();
    }

    /* create a new depot */
    @PostMapping
    public Depot addDepot(@RequestBody Depot depot){
        return depotService.addDepot(depot);
    }

    @GetMapping("/{id}")
    public Depot getDepotByid(@PathVariable Long id){
        return depotService.getDepotById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getPorductsInDepot(@PathVariable Long id){
        return depotService.getProducts(id);
    }

    @PostMapping("/{id}/products")
    public Product addProductToDepot(@PathVariable Long id, @RequestBody Product product){
        System.out.println("Received: "+product);
        return this.depotService.addProductToDepot(id,product);
    }

    @PutMapping("/{id}/products")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return this.depotService.updateProduct(id,product);
    }

}
