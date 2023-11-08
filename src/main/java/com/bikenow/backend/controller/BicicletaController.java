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

import com.bikenow.backend.entities.Bicicleta;
import com.bikenow.backend.service.BicicletaService;

@RestController
@RequestMapping("/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {
  
  @Autowired
  private BicicletaService service;  

  @GetMapping
  public List<Bicicleta> findAll(){
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Bicicleta findById(@PathVariable Long id){
    return service.findById(id);
  }

  @GetMapping("/ciclista/{ciclistaId}")
  public List<Bicicleta> findByCiclistaId(@PathVariable Long ciclistaId){
    return service.findByCiclistaId(ciclistaId);
  }

  @PostMapping()
  public Bicicleta saveCiclista(@RequestBody Bicicleta bicicleta){
    return service.save(bicicleta);
  }

  @PutMapping("/aceito/{id}")
  public Bicicleta aceitoBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta){
    return service.updateAceito(id, bicicleta);
  }

  @PutMapping("/avaliado/{id}")
  public Bicicleta avaliadoBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta){
    return service.updateAvalidado(id, bicicleta);
  }

  @PutMapping("/{id}")
  public Bicicleta updateBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
      return service.update(id, bicicleta);
  }


}
