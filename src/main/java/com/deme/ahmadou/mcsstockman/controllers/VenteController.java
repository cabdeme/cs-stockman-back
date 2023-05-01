package com.deme.ahmadou.mcsstockman.controllers;

import com.deme.ahmadou.mcsstockman.model.VenteForm;
import com.deme.ahmadou.mcsstockman.model.Ventes;
import com.deme.ahmadou.mcsstockman.services.ClientService;
import com.deme.ahmadou.mcsstockman.services.VenteService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class VenteController {
    private final VenteService venteService;



    @GetMapping
    public List<Ventes> getVentes(){
        return this.venteService.getVentes();
    }

    @GetMapping("/{id}")
    public Ventes getVenteById(@PathVariable Long id){
        return this.venteService.getVenteById(id);
    }

    @PostMapping
    public Ventes saveVente(@RequestBody VenteForm venteForm){
        log.info("Received form vente {}",venteForm);
        return this.venteService.saveVente(venteForm);
       // return null;
    }
}

