package com.bikenow.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bikenow.backend.entities.Addon;
import com.bikenow.backend.repositories.AddonRepository;

public class AddonService {
  
  @Autowired
  private AddonRepository repository;

  public List<Addon> findAll(){
    return repository.findAll();
  }

  public Addon findById(Long id){
    if(repository.findById(id).get() == null){
      throw new IllegalArgumentException("Addon with id: " + id + " does not exist");
    }

    return repository.findById(id).get();
  }

  public List<Addon> findByBicicletaId(Long id){
    if(repository.findByBicicletaId(id) == null){
      throw new IllegalArgumentException("Bicicleta with id: " + id + " does not exist");
    }

    return repository.findByBicicletaId(id);
  }

  public Addon save(Addon addon){
    if(addon == null){
      throw new RuntimeException("Addon parameter is null!");
    }

    if(repository.findById(addon.getId()).get() != null){
      throw new IllegalArgumentException("Addon with id: " + addon.getId() + " already exists");
    }

    if(repository.findByBicicletaId(addon.getBicicleta().getId()) != null){
      throw new IllegalArgumentException("Bicicleta with id: " + addon.getBicicleta().getId() + " does not exists");
    }

    return repository.save(addon);
  }

}
