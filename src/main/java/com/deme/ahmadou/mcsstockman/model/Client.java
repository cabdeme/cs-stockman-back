package com.deme.ahmadou.mcsstockman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String adresse;

    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<Ventes> ventesList;
}
