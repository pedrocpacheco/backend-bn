package com.bikenow.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikenow.backend.entities.Analista;

public interface AnalistaRepository extends JpaRepository<Analista, Long>{

  Analista findByRm(String analista);

}
