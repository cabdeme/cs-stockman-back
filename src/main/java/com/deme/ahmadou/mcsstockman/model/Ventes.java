package com.deme.ahmadou.mcsstockman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ventes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long numberOfProducts;
    private Long numberOfBoxes;
    private Long totalAmount;
    private Instant date;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVenteList;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
}
