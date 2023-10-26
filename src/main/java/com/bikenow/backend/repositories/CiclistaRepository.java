package com.bikenow.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikenow.backend.entities.Ciclista;

public interface CiclistaRepository extends JpaRepository<Ciclista, Long>{
  
  public Ciclista findByCpf(String cpf);
  public Ciclista findByNome(String nome);

}
