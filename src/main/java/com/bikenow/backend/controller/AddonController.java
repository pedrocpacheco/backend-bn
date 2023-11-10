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

import com.bikenow.backend.entities.Addon;
import com.bikenow.backend.service.AddonService;

@RestController
@RequestMapping("/addons")
@CrossOrigin(origins = "*")
public class AddonController {
  
  @Autowired
  private AddonService service;  

  @GetMapping()
  public ResponseEntity<List<Addon>> findAll(){
    List<Addon> addons =  service.findAll();
    return ResponseEntity.ok(addons);
  }

  @GetMapping("/bicicleta/{bicicletaId}")
  public ResponseEntity<List<Addon>> findByBicicletaId(@PathVariable Long bicicletaId){
    List<Addon> addons = service.findByBicicletaId(bicicletaId);
    return ResponseEntity.ok(addons);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Addon> findById(@PathVariable Long id){
    Addon addon = service.findById(id);
    return ResponseEntity.ok(addon);
  }

  @PostMapping()
  public ResponseEntity<Addon> save(@RequestBody Addon addon){
    service.save(addon);
    return ResponseEntity.status(HttpStatus.CREATED).body(addon);
  }

}
