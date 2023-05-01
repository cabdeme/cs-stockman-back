package com.deme.ahmadou.mcsstockman.repository;

import com.deme.ahmadou.mcsstockman.model.Depot;
import com.deme.ahmadou.mcsstockman.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepotRepository extends JpaRepository<Depot,Long> {
    List<Product> findProductsById(Long id);


}
