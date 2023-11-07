package com.bikenow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<Addon>> findAll(){
    List<Addon> addons =  repository.findAll();
    return ResponseEntity.ok(addons);
  }

  @GetMapping("/bicicleta/{bicicletaId}")
  public ResponseEntity<List<Addon>> findByBicicletaId(@PathVariable Long bicicletaId){
    List<Addon> addons = repository.findByBicicletaId(bicicletaId);
    return ResponseEntity.ok(addons);
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
