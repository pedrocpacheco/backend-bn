package com.bikenow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<Ciclista>> findAll(){
    var ciclistas = service.findAll();
    return ResponseEntity.ok(ciclistas);
  }

  @GetMapping("/cpf/{cpf}")
  public ResponseEntity<Ciclista> findByCpf(@PathVariable String cpf){
    var ciclista = service.findByCpf(cpf);
    return ResponseEntity.ok(ciclista);
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Ciclista> findById(@PathVariable Long id){
    var ciclista = service.findById(id);
    return ResponseEntity.ok(ciclista);
  }

  @GetMapping("/nome/{nome}")
  public ResponseEntity<Ciclista> findByNome(@PathVariable String nome){
    var ciclista = service.findByNome(nome);
    return ResponseEntity.ok(ciclista);
  }

  @PostMapping()
  public ResponseEntity<Ciclista> save(@RequestBody Ciclista ciclista){
    service.save(ciclista);
    return ResponseEntity.status(HttpStatus.CREATED).body(ciclista);
  }
  

  @PutMapping("/{id}")
    public ResponseEntity<Ciclista> updateCiclista(@PathVariable Long id, @RequestBody Ciclista ciclista){
      var bicicletaUpdated = service.update(id, ciclista);
      return ResponseEntity.ok(bicicletaUpdated);
    }

}
