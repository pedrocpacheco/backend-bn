package com.bikenow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<Analista>> findAll(){
    List<Analista> analistas = service.findAll();
    return ResponseEntity.ok(analistas);
  }

  @GetMapping("/rm/{rm}")
  public ResponseEntity<Analista> findByRm(@PathVariable String rm){
    Analista analista = service.findByRm(rm);
    return ResponseEntity.ok(analista);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Analista> findById(@PathVariable Long id){
    Analista analista = service.findById(id);
    return ResponseEntity.ok(analista);
  }

  @PostMapping()
  public ResponseEntity<Analista> save(@RequestBody Analista analista){
    service.save(analista);
    return ResponseEntity.status(HttpStatus.CREATED).body(analista);
  }
}

