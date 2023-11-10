package com.bikenow.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikenow.backend.entities.Ciclista;
import com.bikenow.backend.repositories.CiclistaRepository;

@Service
public class CiclistaService {
  
  @Autowired
  private CiclistaRepository repository;
  
  public List<Ciclista> findAll(){
    return repository.findAll();
  }

  public Ciclista findByCpf(String cpf){
    if(repository.findByCpf(cpf) == null){
      throw new IllegalArgumentException("Ciclista with cpf: " + cpf + " does not exist");
    }

    return repository.findByCpf(cpf);
  }

  public Ciclista findById(Long id){
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ciclista with id: " + id + " does not exist"));
  }

  public Ciclista findByNome(String nome){
    if(repository.findByNome(nome) == null){
      throw new IllegalArgumentException("Ciclista with nome: " + nome + " does not exist");
    }

    return repository.findByNome(nome);
  }

  public Ciclista save(Ciclista ciclista){
    if(ciclista == null){
      throw new RuntimeException("Ciclista parameter is null!");
    }

    if(repository.findByCpf(ciclista.getCpf()) != null){
      throw new IllegalArgumentException("Ciclista with cpf: " + ciclista.getCpf() + " already exists");
    }

    return repository.save(ciclista);
  }

  public Ciclista update(Long id, Ciclista ciclista){
    if(ciclista == null){
      throw new IllegalArgumentException("Ciclista parameter is null!");
    }

    return repository.save(ciclista);
  }

}
