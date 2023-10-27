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

import com.bikenow.backend.entities.Bicicleta;
import com.bikenow.backend.repositories.BicicletaRepository;
@RestController
@RequestMapping("/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {
  
  @Autowired
  private BicicletaRepository repository;  

  @GetMapping
  public List<Bicicleta> findAll(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Bicicleta findById(@PathVariable Long id){
    return repository.findById(id).get();
  }

  @GetMapping("/ciclista/{ciclistaId}")
  public List<Bicicleta> findByCiclistaId(@PathVariable Long ciclistaId){
    return repository.findByCiclistaId(ciclistaId);
  }

  @PostMapping()
  public Bicicleta saveCiclista(@RequestBody Bicicleta bicicleta){
    return repository.save(bicicleta);
  }

}
