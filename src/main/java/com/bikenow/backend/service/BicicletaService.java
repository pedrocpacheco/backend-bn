package com.bikenow.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bikenow.backend.entities.Bicicleta;
import com.bikenow.backend.repositories.BicicletaRepository;

public class BicicletaService {
  
  @Autowired
  private BicicletaRepository repository;

  public List<Bicicleta> findAll(){
    return repository.findAll();
  }

  public Bicicleta findById(Long id){
    if(repository.findById(id).get() == null){
      throw new IllegalArgumentException("Ciclista with id: " + id + " does not exist");
    }

    return repository.findById(id).get();
  }

  public List<Bicicleta> findByCiclistaId(Long id){
    if(repository.findByCiclistaId(id) == null){
      throw new IllegalArgumentException("Ciclista with cpf: " + id + " does not exist");
    }

    return repository.findByCiclistaId(id);
  }

  public Bicicleta save(Bicicleta bicicleta){
    if(bicicleta == null){
      throw new RuntimeException("Bicicleta parameter is null!");
    }

    if(repository.findById(bicicleta.getId()).get() != null){
      throw new IllegalArgumentException("Bicicleta with id: " + bicicleta.getId() + " already exists");
    }

    if(repository.findByCiclistaId(bicicleta.getCiclista().getId()) != null){
      throw new IllegalArgumentException("Ciclista with id: " + bicicleta.getCiclista().getId() + " does not exists");
    }

    return repository.save(bicicleta);
  }

  public Bicicleta update(Long id, Bicicleta bicicleta){
    if(bicicleta == null){
      throw new IllegalArgumentException("Bicicleta parameter is null!");
    }

    if(repository.findById(id).get() == null){
      throw new IllegalArgumentException("Bicicleta does not exist!");
    }

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

  public Bicicleta updateAceito(Long id, Bicicleta bicicleta){
    var bicicletaUpdated = repository.findById(id).get();
    bicicletaUpdated.setAceito(bicicleta.getAceito());

    return repository.save(bicicletaUpdated);
  }

  public Bicicleta updateAvalidado(Long id, Bicicleta bicicleta){
    var bicicletaUpdated = repository.findById(id).get();
    bicicletaUpdated.setAvaliado(bicicleta.getAvaliado());
    
    return repository.save(bicicletaUpdated);
  }

}
