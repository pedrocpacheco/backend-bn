package com.bikenow.backend.controller;

import java.util.Arrays;
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
import com.bikenow.backend.repositories.BicicletaRepository;
@RestController
@RequestMapping("/bicicletas")
@CrossOrigin(origins = "*")
public class BicicletaController {
  
  @Autowired
  private BicicletaRepository repository;  

  @GetMapping
  public List<Bicicleta> findAll(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Bicicleta findById(@PathVariable Long id){
    return repository.findById(id).get();
  }

  @GetMapping("/ciclista/{ciclistaId}")
  public List<Bicicleta> findByCiclistaId(@PathVariable Long ciclistaId){
    return repository.findByCiclistaId(ciclistaId);
  }

  @PostMapping()
  public Bicicleta saveCiclista(@RequestBody Bicicleta bicicleta){
    return repository.save(bicicleta);
  }

  @PutMapping("/aceito/{id}")
  public Bicicleta aceitoBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta){
    var bicicletaUpdated = repository.findById(id).get();
    bicicletaUpdated.setAceito(bicicleta.getAceito());
    return repository.save(bicicletaUpdated);
  }

  @PutMapping("/{id}")
  public Bicicleta updateBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
      var bicicletaUpdated = repository.findById(id).get();

      // Verifique o formato da entrada e formate as imagens adequadamente
      if (bicicleta.getImages().size() == 1 && bicicleta.getImages().get(0).contains(",")) {
          // Se as imagens estiverem em uma única string separada por vírgula, divida-as em uma matriz
          String[] imageUrls = bicicleta.getImages().get(0).split(",");
          bicicletaUpdated.setImages(Arrays.asList(imageUrls));
      } else {
          // Caso contrário, assuma que já está no formato de matriz de strings
          bicicletaUpdated.setImages(bicicleta.getImages());
          bicicletaUpdated.setAceito(bicicleta.getAceito());
      }

      return repository.save(bicicletaUpdated);
  }


}
