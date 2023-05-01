package com.deme.ahmadou.mcsstockman.model;

import lombok.Data;

import java.util.List;

@Data
public class VenteForm{
    private Long client;
    private List<LigneVenteForm> products;
}


