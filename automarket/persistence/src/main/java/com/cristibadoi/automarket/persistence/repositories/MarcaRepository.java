package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Long> {

  public Marca findByNume(String nume);

}
