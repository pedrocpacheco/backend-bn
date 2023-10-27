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
import com.bikenow.backend.repositories.CiclistaRepository;

@RestController
@RequestMapping("/ciclistas")
@CrossOrigin(origins = "*")
public class CiclistaController {
  
  @Autowired
  private CiclistaRepository repository;

  @GetMapping
  public List<Ciclista> findAll(){
    return repository.findAll();
  }

  @GetMapping("/cpf/{cpf}")
  public Ciclista findByCpf(@PathVariable String cpf){
    return repository.findByCpf(cpf);
  }

  @GetMapping("/id/{id}")
  public Ciclista findById(@PathVariable Long id){
    return repository.findById(id).get();
  }

  @GetMapping("/nome/{nome}")
  public Ciclista findByNome(@PathVariable String nome){
    return repository.findByNome(nome);
  }

  @PostMapping()
  public Ciclista saveCiclista(@RequestBody Ciclista ciclista){
    return repository.save(ciclista);
  }

  @PutMapping("/{id}")
    public Ciclista updateCiclista(@PathVariable Long id, @RequestBody Ciclista ciclista){
      return repository.save(ciclista);
    }

}
