package com.deme.ahmadou.mcsstockman.services;

import com.deme.ahmadou.mcsstockman.model.*;
import com.deme.ahmadou.mcsstockman.repository.LigneVenteRepository;
import com.deme.ahmadou.mcsstockman.repository.ProductRepository;
import com.deme.ahmadou.mcsstockman.repository.VenteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VenteService {
    private final VenteRepository venteRepository;
    private final ClientService clientService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final LigneVenteRepository ligneVenteRepository;

    public List<Ventes> getVentes(){
        return this.venteRepository.findAll();
    }

    public Ventes saveVente(VenteForm venteForm){
//        log.info("Received form vente {}",venteForm);
        Ventes vente = new Ventes();

        Client client = this.clientService.getClientById(venteForm.getClient());
        if(client!= null){
            vente.setClient(client);
        }else{
            return null;
        }

        vente.setNumberOfProducts((long) venteForm.getProducts().size());

        vente.setDate(Instant.now());

        vente.setNumberOfBoxes(0L);
        vente.setTotalAmount(0L);

        venteForm.getProducts().forEach(product -> {
            log.info("A product {}",product);
            vente.setNumberOfBoxes(vente.getNumberOfBoxes()+product.getCarton());
            Product findRelatedProduct = this.productService.getProductById(product.getProduct());
            vente.setTotalAmount(vente.getTotalAmount()+(findRelatedProduct.getPrix()*product.getCarton()));
        });

        log.info("Saving new vente {}",vente);
        Ventes savedVente = this.venteRepository.save(vente);

        // save lignes vente and update product
        venteForm.getProducts().forEach(product -> {
            Product relatedProduct = this.productService.getProductById(product.getProduct());
            // create and save ligne vente
            LigneVente ligneVente = new LigneVente();
            ligneVente.setVente(savedVente);
            ligneVente.setProduct(relatedProduct);
            ligneVente.setQuantity(product.getCarton());
            this.ligneVenteRepository.save(ligneVente);

            // update and save product
            //relatedProduct.setCarton(relatedProduct.getCarton()-Math.toIntExact(product.getCarton()));
            relatedProduct.setVendu((int) (relatedProduct.getVendu()+product.getCarton()));
            this.productRepository.save(relatedProduct);
        });
        return savedVente;

        //return null;
    }

    public Ventes getVenteById(Long id) {
        return this.venteRepository.findById(id).orElse(null);
    }
}

