package com.bikenow.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikenow.backend.entities.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{

  List<Bicicleta> findByCiclistaId(Long id);

}
