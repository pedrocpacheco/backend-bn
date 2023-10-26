package com.bikenow.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikenow.backend.entities.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{
  
}
