package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Tara;

public interface TaraRepository extends CrudRepository<Tara, Long> {

  public Tara findByNume(String nume);

}
