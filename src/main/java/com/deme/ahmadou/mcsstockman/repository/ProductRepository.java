package com.deme.ahmadou.mcsstockman.repository;

import com.deme.ahmadou.mcsstockman.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findProductsByDepotIdIs(Long id);
}
