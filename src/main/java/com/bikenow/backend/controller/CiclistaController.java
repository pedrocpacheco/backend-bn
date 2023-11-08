package com.bikenow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikenow.backend.entities.Ciclista;
import com.bikenow.backend.service.CiclistaService;

@RestController
@RequestMapping("/ciclistas")
@CrossOrigin(origins = "*")
public class CiclistaController {
  
  @Autowired
  private CiclistaService service;

  @GetMapping
  public List<Ciclista> findAll(){
    return service.findAll();
  }

  @GetMapping("/cpf/{cpf}")
  public Ciclista findByCpf(@PathVariable String cpf){
    return service.findByCpf(cpf);
  }

  @GetMapping("/id/{id}")
  public Ciclista findById(@PathVariable Long id){
    return service.findById(id);
  }

  @GetMapping("/nome/{nome}")
  public Ciclista findByNome(@PathVariable String nome){
    return service.findByNome(nome);
  }

  @PostMapping()
  public Ciclista saveCiclista(@RequestBody Ciclista ciclista){
    return service.save(ciclista);
  }

  @PutMapping("/{id}")
    public Ciclista updateCiclista(@PathVariable Long id, @RequestBody Ciclista ciclista){
      return service.update(id, ciclista);
    }

}
