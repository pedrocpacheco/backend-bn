package com.bikenow.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

  @PostMapping()
  public Addon saveCiclista(@RequestBody Addon addon){
    return repository.save(addon);
  }

}
