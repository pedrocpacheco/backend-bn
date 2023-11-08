package com.bikenow.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bikenow.backend.entities.Analista;
import com.bikenow.backend.repositories.AnalistaRepository;

public class AnalistaService {
  
  @Autowired
  private AnalistaRepository repository;

  public List<Analista> findAll(){
    return repository.findAll();
  }

  public Analista findByRm(String rm){
    if(repository.findByRm(rm) == null){
      throw new IllegalArgumentException("Analista with rm: " + rm + " does not exist");
    }

    return repository.findByRm(rm);
  }

  public Analista findById(Long id){
    if(repository.findById(id).get() == null){
      throw new IllegalArgumentException("Analista with id: " + id + " does not exist");
    }

    return repository.findById(id).get();
  }

  public Analista save(Analista analista){
    if(analista == null){
      throw new RuntimeException("Analista parameter is null!");
    }

    if(repository.findById(analista.getId()).get() != null){
      throw new IllegalArgumentException("Analista with id: " + analista.getId() + " already exists");
    }

    if(repository.findByRm(analista.getRm()) != null){
      throw new IllegalArgumentException("Analista with rm: " + analista.getRm() + " already exists");
    }

    return repository.save(analista);
  }
}
