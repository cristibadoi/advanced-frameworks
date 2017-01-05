package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Combustibil;

public interface CombustibilRepository extends CrudRepository<Combustibil, Long> {

  public Combustibil findByNume(String nume);

}
