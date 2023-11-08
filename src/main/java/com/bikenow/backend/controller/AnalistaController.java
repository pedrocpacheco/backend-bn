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

import com.bikenow.backend.entities.Analista;
import com.bikenow.backend.service.AnalistaService;

@RestController
@RequestMapping("/analistas")
@CrossOrigin(origins = "*")
public class AnalistaController {
  
  @Autowired
  private AnalistaService service;

  @GetMapping()
  public List<Analista> findAll(){
    return service.findAll();
  }

  @GetMapping("/rm/{rm}")
  public Analista findByRm(@PathVariable String rm){
    return service.findByRm(rm);
  }
  
  @GetMapping("/{id}")
  public Analista findById(@PathVariable Long id){
    return service.findById(id);
  }

  @PostMapping()
  public Analista saveCiclista(@RequestBody Analista analista){
    return service.save(analista);
  }
}

