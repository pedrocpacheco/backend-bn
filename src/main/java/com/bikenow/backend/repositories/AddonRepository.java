package com.bikenow.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikenow.backend.entities.Addon;

public interface AddonRepository extends JpaRepository<Addon, Long>{
  
  List<Addon> findByBicicletaId(Long id);

}
