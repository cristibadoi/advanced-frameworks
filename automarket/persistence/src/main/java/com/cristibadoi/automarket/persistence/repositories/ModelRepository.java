package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Model;

public interface ModelRepository extends CrudRepository<Model, Long> {

  public Model findByNumeAndIdMarca(String nume, String idMarca);

}
