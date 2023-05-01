package com.deme.ahmadou.mcsstockman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    private Integer carton;
    private Integer pieces;
    private String designation;
    private Integer prix;
    private Integer vendu;

    @ManyToOne
    @JoinColumn(name = "idDepot")
    private Depot depot;


}
