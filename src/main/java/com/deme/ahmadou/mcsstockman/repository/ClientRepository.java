package com.deme.ahmadou.mcsstockman.repository;

import com.deme.ahmadou.mcsstockman.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
