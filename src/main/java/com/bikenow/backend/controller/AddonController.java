package com.bikenow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikenow.backend.entities.Addon;
import com.bikenow.backend.repositories.AddonRepository;

@RestController
@RequestMapping("/addons")
@CrossOrigin(origins = "*")
public class AddonController {
  
  @Autowired
  private AddonRepository repository;  


  @GetMapping()
  public List<Addon> findAll(){
    return repository.findAll();
  }

  @GetMapping("/bicicleta/{bicicletaId}")
  public List<Addon> findByBicicletaId(@PathVariable Long bicicletaId){
    return repository.findByBicicletaId(bicicletaId);
  }

  @GetMapping("/{id}")
  public Addon findById(@PathVariable Long id){
    return repository.findById(id).get();
  }

  @PostMapping()
  public Addon saveCiclista(@RequestBody Addon addon){
    return repository.save(addon);
  }

}
