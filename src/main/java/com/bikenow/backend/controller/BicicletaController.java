package com.bikenow.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

  @PostMapping()
  public Bicicleta saveCiclista(@RequestBody Bicicleta bicicleta){
    return repository.save(bicicleta);
  }

}
