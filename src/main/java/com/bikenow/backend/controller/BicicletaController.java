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

import com.bikenow.backend.entities.Bicicleta;
import com.bikenow.backend.service.BicicletaService;

@RestController
@RequestMapping("/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {
  
  @Autowired
  private BicicletaService service;  

  @GetMapping
  public ResponseEntity<List<Bicicleta>> findAll(){
    var bicicletas = service.findAll();
    return ResponseEntity.ok(bicicletas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Bicicleta> findById(@PathVariable Long id){
    var bicicleta = service.findById(id);
    return ResponseEntity.ok(bicicleta);
  }

  @GetMapping("/ciclista/{ciclistaId}")
  public ResponseEntity<List<Bicicleta>> findByCiclistaId(@PathVariable Long ciclistaId){
    var bicicletas = service.findByCiclistaId(ciclistaId);
    return ResponseEntity.ok(bicicletas);
  }

  @PostMapping()
  public ResponseEntity<Bicicleta> save(@RequestBody Bicicleta bicicleta){
    service.save(bicicleta);
    return ResponseEntity.status(HttpStatus.CREATED).body(bicicleta);
  }

  @PutMapping("/aceito/{id}")
  public ResponseEntity<Bicicleta> aceitoBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta){
    var bicicletaUpdated = service.updateAceito(id, bicicleta);
    return ResponseEntity.ok(bicicletaUpdated);
  }

  @PutMapping("/avaliado/{id}")
  public ResponseEntity<Bicicleta> avaliadoBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta){
    var bicicletaUpdated = service.updateAvalidado(id, bicicleta);
    return ResponseEntity.ok(bicicletaUpdated);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Bicicleta> update(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
    var bicicletaUpdated = service.update(id, bicicleta);  
    return ResponseEntity.ok(bicicletaUpdated);
  }


}
