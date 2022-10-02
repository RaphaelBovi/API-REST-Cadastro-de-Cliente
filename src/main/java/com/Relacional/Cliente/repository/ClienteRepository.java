package com.Relacional.Cliente.repository;

import com.Relacional.Cliente.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    boolean existsByDocument(String document);

    Optional<Cliente> findByDocument(String document);


}
