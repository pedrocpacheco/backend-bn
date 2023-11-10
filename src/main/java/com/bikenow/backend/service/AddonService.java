package com.bikenow.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikenow.backend.entities.Addon;
import com.bikenow.backend.repositories.AddonRepository;

@Service
public class AddonService {
  
  @Autowired
  private AddonRepository repository;

  public List<Addon> findAll(){
    return repository.findAll();
  }

  public Addon findById(Long id){
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Addon with id: " + id + " does not exist"));
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

    if(repository.findByBicicletaId(addon.getBicicleta().getId()) != null){
      throw new IllegalArgumentException("Bicicleta with id: " + addon.getBicicleta().getId() + " does not exists");
    }

    return repository.save(addon);
  }

}
